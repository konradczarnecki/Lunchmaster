import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';

import { Restaurant } from '../../model';
import { ThemeService } from '../../theme/theme.service';

@Component({
  selector: 'app-restaurant-tile',
  templateUrl: './restaurant-tile.component.html',
  styleUrls: ['./restaurant-tile.component.scss']
})
export class RestaurantTileComponent implements OnInit {

  @Input() restaurant: Restaurant | Restaurant;

  @ViewChild('tile') tile: ElementRef;

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }
}
