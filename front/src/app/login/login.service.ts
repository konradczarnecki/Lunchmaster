import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers} from '@angular/http';
import { CanActivate, Router} from '@angular/router';

import { User } from '../model';
import { environment } from '../../environments/environment';

@Injectable()
export class LoginService implements CanActivate {

  logged: boolean;
  user: User;

  constructor(private http: Http, private router: Router) {

    const user: User = JSON.parse(sessionStorage.getItem('user'));

    if(user){

      this.logged = true;
      this.user = user;

    } else this.logged = false;
  }

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

        if(response.json().status === 'success'){
          this.logged = true;
          this.user = response.json().content;
          sessionStorage.setItem('user', JSON.stringify(this.user));
        }

        resolve(this.logged);
      });
    });
  }

  logout(): void {

    this.logged = false;
    this.user = null;
    sessionStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  canActivate() {

    return this.logged;
  }

}
