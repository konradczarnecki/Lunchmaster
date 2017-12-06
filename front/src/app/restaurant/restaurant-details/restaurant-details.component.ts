import { Component, Input, OnInit, Output, EventEmitter, ChangeDetectorRef } from '@angular/core';

import { ThemeService } from '../../theme/theme.service';
import { LoginService } from '../../login/login.service';
import { RestaurantService } from '../service/restaurant.service';
import { Restaurant } from '../../model';

@Component({
  selector: 'app-restaurant-details',
  templateUrl: './restaurant-details.component.html',
  styleUrls: ['./restaurant-details.component.scss'],
})
export class RestaurantDetailsComponent implements OnInit {

  @Input() restaurant: Restaurant | Restaurant;
  @Output() close = new EventEmitter<boolean>();
  @Output() refresh = new EventEmitter<boolean>();

  dishInput: string;
  dishPriceInput;

  constructor(public theme: ThemeService,
              public service: RestaurantService,
              public loginService: LoginService,
              public changeDetector: ChangeDetectorRef) { }

  ngOnInit() {

  }

  clickClose(): void {

    this.close.emit(true);
  }

  addDish(): void {

  }
}
