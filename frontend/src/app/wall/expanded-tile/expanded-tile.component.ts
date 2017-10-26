import {Component, Input, OnInit} from '@angular/core';
import {Lunch} from "../../model";

@Component({
  selector: 'expanded-tile',
  templateUrl: './expanded-tile.component.html',
  styleUrls: ['./expanded-tile.component.scss']
})
export class ExpandedTileComponent implements OnInit {

  @Input() lunch: Lunch;

  constructor() { }

  ngOnInit() {
  }

  clicked(index: number) {

  }

}
