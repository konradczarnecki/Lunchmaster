import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';

import { LoginService } from '../../login/login.service';
import { environment } from '../../../environments/environment';
import { Lunch } from '../../model';

@Injectable()
export class WallService {

  constructor(private http: Http, private loginService: LoginService) { }

  getLunches(): Promise<Lunch[]> {

    const headers = new Headers({
      'Authorization': 'Bearer '+ this.loginService.token()
    });

    const options = new RequestOptions({ headers: headers });

    return new Promise<Lunch[]>( resolve => {

      this.http.get(`${environment.apiHost}/api/lunch/list`, options)
        .toPromise().then(response => resolve(response.json()));
    });

  }

}
