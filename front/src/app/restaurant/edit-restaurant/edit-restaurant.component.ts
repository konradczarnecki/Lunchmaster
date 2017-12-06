import { Component, EventEmitter, OnInit, Output } from '@angular/core';

import { ThemeService } from '../../theme/theme.service';
import { LoginService } from '../../login/login.service';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from '../../model';

@Component({
  selector: 'app-edit-restaurant',
  templateUrl: './edit-restaurant.component.html',
  styleUrls: ['./edit-restaurant.component.scss']
})
export class EditRestaurantComponent implements OnInit {

  @Output() close = new EventEmitter<boolean>();
  @Output() refresh = new EventEmitter<boolean>();

  restaurant: Restaurant;
  fields: [{label: string, binding: string}] = fields;

  constructor(public theme: ThemeService,
              public service: RestaurantService,
              public loginService: LoginService) { }

  ngOnInit() {

    this.restaurant = {
      id : null,
      name : '',
      description : '',
      logo : '',
      phone : '',
      address : '',
      link : '',
      avgDeliveryTime : null
    };
  }

  submit(){

    for(const field in this.restaurant)
      if(this.restaurant.hasOwnProperty(field) && !this.restaurant[field] && field !== 'id' && field !== 'address') return;

    this.service.addRestaurant(this.restaurant).then(result => {

      if(result) this.refresh.emit(true);
    });
  }

  clickClose(){

    this.close.emit(true);
  }
}

const fields: [{label: string, binding: string}] = [
  { label : 'Name', binding : 'name' },
  { label : 'Description', binding : 'description' },
  { label : 'Phone', binding : 'phone' },
  { label : 'Address', binding : 'address' },
  { label : 'Avg. delivery', binding : 'avgDeliveryTime' },
  { label : 'Link', binding : 'link' },
  { label : 'Logo link', binding : 'logo' },
];
