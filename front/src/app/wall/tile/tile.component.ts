import {Component, Input, OnInit} from '@angular/core';
import { Lunch } from '../../model';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss']
})
export class TileComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;

  constructor() { }

  ngOnInit() {
  }

}
