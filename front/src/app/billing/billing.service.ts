import { Injectable } from '@angular/core';
import {Balance} from '../model';
import {Headers, Http, RequestOptions} from '@angular/http';
import {environment} from '../../environments/environment';
import { LoginService} from '../login/login.service';

@Injectable()
export class BillingService {

  constructor(private http: Http, private loginService: LoginService) { }

  getBilling(): Promise<Balance> {

    return new Promise<Balance>(resolve => {

      this.http.get(`${environment.apiHost}/api/balance`, this.requestOptions()).subscribe(response => {

        resolve(response.json());
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
