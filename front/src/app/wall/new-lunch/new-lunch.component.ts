import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ThemeService} from "../../theme/theme.service";

@Component({
  selector: 'app-new-lunch',
  templateUrl: './new-lunch.component.html',
  styleUrls: ['./new-lunch.component.scss']
})
export class NewLunchComponent implements OnInit {

  @Output() close = new EventEmitter<boolean>();

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }

  clickClose(){

    this.close.emit(true);
  }

}
