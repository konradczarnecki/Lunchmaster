import { ChangeDetectorRef, Component, OnInit} from '@angular/core';


import { ThemeService} from '../theme/theme.service';
import {Lunch, Restaurant} from '../model';

import { fadeAnimation, slideAnimation, slideUpAnimation } from './animations';
import {RestaurantService} from './service/restaurant.service';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.scss'],
  animations : [ slideAnimation, slideUpAnimation, fadeAnimation ],
})
export class RestaurantsComponent implements OnInit {

  restaurants: Restaurant[];
  selected: number;

  newRestaurantOpened: boolean;

  constructor(public theme: ThemeService,
              private service: RestaurantService,
              private changeDet: ChangeDetectorRef) { }

  get tilesInactive(): boolean {

    return this.selected !== -1 || this.newRestaurantOpened === true;
  }

  ngOnInit() {

    this.fetchRestaurants();
    this.selected = -1;

    window.onresize = this.adjustGrid.bind(this);
  }

  adjustGrid() {

    const tileWidth = 400;
    const tilesInWindow = 0.8 * window.innerWidth / tileWidth;
    const extraGap = tilesInWindow - Math.floor(tilesInWindow);
    const multiplier = extraGap > 0.3 ? Math.floor(tilesInWindow + 0.3) : tilesInWindow;
    const gridWidth =  multiplier  * (tileWidth + 15);

    document.getElementById('grid').style.width = gridWidth + 'px';
    this.changeDet.detectChanges();
  }

  fetchRestaurants() {

    this.service.getRestaurants().then(restaurants => {

      this.restaurants = restaurants;
      this.adjustGrid();
    });
  }

  openDetails(index: number){

    this.newRestaurantOpened = false;
    this.selected = index;
  }

  onDetailsClosed(){

    this.selected = -1;
  }

  openNewRestaurant(){

    this.selected = -1;
    this.newRestaurantOpened = true;
  }

  onNewRestaurantClosed(){

    this.newRestaurantOpened = false;
  }

  onRestaurantsModified(){

    this.newRestaurantOpened = false;
    this.selected = -1;
    this.fetchRestaurants();
  }
}
