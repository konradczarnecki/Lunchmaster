import { Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { ThemeService} from '../../theme/theme.service';
import { Lunch, Restaurant } from '../../model';
import { WallService} from '../service/wall.service';
import { LoginService} from '../../login/login.service';

@Component({
  selector: 'app-new-lunch',
  templateUrl: './new-lunch.component.html',
  styleUrls: ['./new-lunch.component.scss']
})
export class NewLunchComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;

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
    const res = this.restaurants.find(restaurant => restaurant.name === value);
    if(res) this.expected = res.avgDeliveryTime + '';
  }

  ngOnInit() {

    this.service.getRestaurants().then(restaurants => {

      this.restaurants = restaurants;
    });

    if(this.lunch){

      this._chosenRestaurant = this.lunch.restaurant.name;

      let hours: any = new Date(this.lunch.deadline).getHours();
      if(hours < 10) hours = '' + 0 + hours;

      let minutes: any = new Date(this.lunch.deadline).getMinutes();
      if(minutes < 10) minutes = '' + 0 + minutes;

      this.deadline = hours + ':' + minutes;
      this.expected = this.lunch.expectedDelivery + '';
    }
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

    const id = this.lunch ? this.lunch.id : null;

    const lunch = {

      id : id,
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
