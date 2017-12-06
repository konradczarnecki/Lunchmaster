import { ChangeDetectorRef, Component, ElementRef, OnInit, Renderer2, ViewChild} from '@angular/core';

import { WallService } from './service/wall.service';
import { ThemeService} from '../theme/theme.service';
import { Lunch } from '../model';

import { fadeAnimation, slideAnimation, slideUpAnimation } from './animations';

@Component({
  selector: 'app-wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.scss'],
  animations : [slideAnimation, slideUpAnimation, fadeAnimation],
})
export class WallComponent implements OnInit {

  @ViewChild('grid') grid: ElementRef;

  lunches: Lunch[];
  selected: number;

  newLunchOpened: boolean;
  lunchToEdit: Lunch;
  lunchForList: Lunch;

  constructor(public theme: ThemeService,
              public service: WallService,
              public changeDet: ChangeDetectorRef,
              public renderer: Renderer2) { }

  get tilesInactive(): boolean {

    return this.selected !== -1 || this.newLunchOpened === true;
  }

  ngOnInit() {

    this.fetchLunches();
    this.selected = -1;

    window.onresize = () => ThemeService.adjustGrid(this);
  }

  fetchLunches() {

    this.service.getLunches().then(lunches => {

      this.lunches = lunches;
      ThemeService.adjustGrid(this);
    });
  }

  openDetails(index: number){

    this.newLunchOpened = false;
    this.selected = index;
  }

  onDetailsClosed(){

    this.selected = -1;
    this.lunchToEdit = undefined;
  }

  openNewLunch(){

    this.selected = -1;
    this.newLunchOpened = true;
  }

  onNewLunchClosed(){

    this.newLunchOpened = false;
    this.lunchToEdit = undefined;
  }

  openEditLunch(lunch: Lunch){

    this.selected = -1;
    this.lunchToEdit = lunch;
    this.newLunchOpened = true;
  }

  openList(lunch: Lunch){

    this.lunchForList = lunch;
  }

  onListClosed(){

    this.lunchForList = undefined;
  }

  onLunchesModified(){

    this.newLunchOpened = false;
    this.lunchToEdit = undefined;
    this.selected = -1;
    this.fetchLunches();
  }
}
