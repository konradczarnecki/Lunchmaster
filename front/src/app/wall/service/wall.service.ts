import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { environment } from '../../../environments/environment';
import { Lunch, Order, Restaurant } from '../../model';

@Injectable()
export class WallService {

  constructor(private http: Http) { }

  getLunches(): Promise<Lunch[]> {

    return new Promise<Lunch[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/lunch/list`).subscribe(response => resolve(response.json()));
    });
  }

  getRestaurants(): Promise<Restaurant[]> {

    return new Promise<Restaurant[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/restaurant/list`).subscribe(response => resolve(response.json()));
    });
  }

  newLunch(lunch: any): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.put(`${environment.apiHost}/api/lunch/save`, lunch).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

  deleteLunch(id: number): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.delete(`${environment.apiHost}/api/lunch/delete?id=` + id).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

  placeOrder(order: Order): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.put(`${environment.apiHost}/api/lunch/order/save`, order).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

  deleteOrder(id: number): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.delete(`${environment.apiHost}/api/lunch/order/delete?id=` + id).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

}
