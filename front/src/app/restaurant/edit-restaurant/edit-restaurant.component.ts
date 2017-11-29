import { Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

import { ThemeService} from '../../theme/theme.service';
import { LoginService} from '../../login/login.service';
import { Lunch, Restaurant } from '../../model';
import {RestaurantService} from '../service/restaurant.service';

@Component({
  selector: 'app-edit-restaurant',
  templateUrl: './edit-restaurant.component.html',
  styleUrls: ['./edit-restaurant.component.scss']
})
export class EditRestaurantComponent implements OnInit {

  @Input() restaurant: Restaurant | Restaurant;

  @Output() close = new EventEmitter<boolean>();
  @Output() refresh = new EventEmitter<boolean>();


  constructor(public theme: ThemeService,
              public service: RestaurantService,
              public loginService: LoginService) { }


  ngOnInit() {


  }

  submit(){

  }

  clickClose(){

    this.close.emit(true);
  }
}
