import { Component, Input, OnInit } from '@angular/core';

import { ThemeService } from '../../theme/theme.service';
import { Lunch } from '../../model';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss']
})
export class TileComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }
}
