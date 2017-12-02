import {ChangeDetectorRef, Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';


import { ThemeService} from '../theme/theme.service';
import { Restaurant} from '../model';

import { fadeAnimation, slideAnimation, slideUpAnimation } from './animations';
import {RestaurantService} from './service/restaurant.service';

@Component({
  selector: 'app-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.scss'],
  animations : [ slideAnimation, slideUpAnimation, fadeAnimation ],
})
export class RestaurantsComponent implements OnInit {

  @ViewChild('grid') grid: ElementRef;

  restaurants: Restaurant[];
  selected: number;

  newRestaurantOpened: boolean;

  constructor(public theme: ThemeService,
              public service: RestaurantService,
              public changeDet: ChangeDetectorRef,
              public renderer: Renderer2) { }

  get tilesInactive(): boolean {

    return this.selected !== -1 || this.newRestaurantOpened === true;
  }

  ngOnInit() {

    this.fetchRestaurants();
    this.selected = -1;

    window.onresize = () => ThemeService.adjustGrid(this);
  }

  fetchRestaurants() {

    this.service.getRestaurants().then(restaurants => {

      this.restaurants = restaurants;
      ThemeService.adjustGrid(this);
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
