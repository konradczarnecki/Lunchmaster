import { Injectable } from '@angular/core';
import {Restaurant} from "../../model";
import {Http} from "@angular/http";
import {environment} from "../../../environments/environment";

@Injectable()
export class RestaurantService {

  constructor(private http: Http) { }

  getRestaurants(): Promise<Restaurant[]> {

    return new Promise<Restaurant[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/restaurant/list`).subscribe(response => resolve(response.json()));
    });
  }

  addRestaurant(restaurant: Restaurant): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.put(`${environment.apiHost}/api/restaurant/save`, restaurant).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

}
