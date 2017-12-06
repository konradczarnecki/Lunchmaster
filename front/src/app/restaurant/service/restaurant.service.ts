import { Injectable } from '@angular/core';
import { Restaurant } from '../../model';
import { Http, RequestOptions, Headers} from '@angular/http';
import { environment } from '../../../environments/environment';
import { LoginService} from '../../login/login.service';

@Injectable()
export class RestaurantService {

  constructor(private http: Http, private loginService: LoginService) { }

  getRestaurants(): Promise<Restaurant[]> {

    return new Promise<Restaurant[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/restaurant/list`, this.requestOptions()).subscribe(response =>

        resolve(response.json())
      );
    });
  }

  addRestaurant(restaurant: Restaurant): Promise<boolean> {

    return new Promise<boolean>(resolve => {

      this.http.put(`${environment.apiHost}/api/restaurant/save`, restaurant, this.requestOptions()).subscribe(response => {

        resolve(response.json().status === 'success');
      });
    });
  }

  requestOptions(): RequestOptions {

    const headers = new Headers({
      'Authorization': 'Bearer '+ this.loginService.token()
    });

    return new RequestOptions({ headers: headers });
  }

}
