import {Component, Input, OnInit, Output, EventEmitter, HostBinding} from '@angular/core';
import { ThemeService } from '../../theme/theme.service';
import { Lunch } from '../../model';
import {animate, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;
  @Output() close = new EventEmitter<boolean>();

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }

  clickClose() {
    this.close.emit(true);
  }

}
