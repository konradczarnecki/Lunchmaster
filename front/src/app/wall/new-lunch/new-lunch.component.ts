import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ThemeService} from "../../theme/theme.service";
import {Restaurant} from "../../model";
import {WallService} from "../service/wall.service";
import {LoginService} from "../../login/login.service";

@Component({
  selector: 'app-new-lunch',
  templateUrl: './new-lunch.component.html',
  styleUrls: ['./new-lunch.component.scss']
})
export class NewLunchComponent implements OnInit {

  @Output() close = new EventEmitter<boolean>();
  @Output() refresh = new EventEmitter<boolean>();


  private _chosenRestaurant: string;
  deadline: string;
  expected: string;

  restaurants: Restaurant[];

  constructor(public theme: ThemeService,
              public service: WallService,
              public loginService: LoginService) { }

  get chosenRestaurant(){

    return this._chosenRestaurant;
  }

  set chosenRestaurant(value: string){

    this._chosenRestaurant = value;
    this.expected = this.restaurants.find(restaurant => restaurant.name === value).avgDeliveryTime + '';
  }

  ngOnInit() {

    this.service.getRestaurants().then(restaurants => {

      this.restaurants = restaurants;
    });
  }

  clickClose(){

    this.close.emit(true);
  }

  createLunch(){

    const hourRegex = /[0-2][0-9]:[0-5][0-9]/;
    const expectedRegex = /[0-9]*/;
    const restaurant = this.restaurants.find(res => res.name === this._chosenRestaurant);

    if(restaurant == null || !hourRegex.test(this.deadline) || !expectedRegex.test(this.expected)){
      console.log(restaurant == null );
      console.log(!hourRegex.test(this.deadline));
      console.log(!expectedRegex.test(this.expected));
      return;
    }

    const deadlineDate = new Date();
    deadlineDate.setHours(0, 0, 0, 0);

    const hours = Number(this.deadline.substring(0, 2));
    const minutes = Number(this.deadline.substring(3, 5));
    deadlineDate.setHours(hours, minutes);

    const lunch = {

      status : 'OPEN',
      restaurant : {
        id : restaurant.id
      },
      lunchMaster : {
        id : this.loginService.user.id
      },
      deadline : deadlineDate.getTime(),
      expectedDelivery : this.expected
    };

    this.service.newLunch(lunch).then(result => {

      if(result) this.refresh.emit(true);
    });
  }
}
