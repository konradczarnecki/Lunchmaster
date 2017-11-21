import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Lunch, Order} from '../../model';
import { environment } from '../../../environments/environment';

@Injectable()
export class WallService {

  constructor(private http: Http) { }

  getLunches(): Promise<Lunch[]> {

    return new Promise<Lunch[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/lunch/list`).subscribe(response => resolve(response.json()));
    });
  }

  placeOrder(order: Order): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.post(`${environment.apiHost}/api/order/save`, order).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

  deleteOrder(id: number): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.delete(`${environment.apiHost}/api/order/delete?id=` + id).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

}
