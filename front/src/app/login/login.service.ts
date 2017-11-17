import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers} from '@angular/http';

import { environment } from '../../environments/environment';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  login(mail: string, password: string): Promise<boolean> {

    const body = {
      email : mail,
      password : password
    };

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    const options = new RequestOptions({ headers : headers});

    return new Promise<boolean>(resolve => {

      this.http.post(`${environment.apiHost}/api/user/login`, body, options).subscribe(response => {

        console.log(response.json());

        if(response.json().status === 'success') resolve(true);
        else resolve(false);
      });
    });
  }

}
