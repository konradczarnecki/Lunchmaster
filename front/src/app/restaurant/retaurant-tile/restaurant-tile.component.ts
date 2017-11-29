import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';

import {Lunch, Restaurant} from '../../model';
import { ThemeService } from '../../theme/theme.service';

@Component({
  selector: 'app-restaurant-tile',
  templateUrl: './restaurant-tile.component.html',
  styleUrls: ['./restaurant-tile.component.scss']
})
export class RestaurantTileComponent implements OnInit {

  @Input() restaurant: Restaurant | Restaurant;

  @ViewChild('tile') tile: ElementRef;

  constructor(private theme: ThemeService) { }

  ngOnInit() {
  }

  mouseOver(){

    this.tile.nativeElement.style.boxShadow = '0 0 6px 1px ' + this.theme.highlightColor;
  }

  mouseLeave(){

    this.tile.nativeElement.style.boxShadow = 'none';
  }

  mouseDown(){

    this.tile.nativeElement.style.boxShadow = 'inset 0 0 3px 1px ' + this.theme.highlightColor;
  }

  mouseUp(){

    this.tile.nativeElement.style.boxShadow = '0 0 6px 1px ' + this.theme.highlightColor;
  }
}
