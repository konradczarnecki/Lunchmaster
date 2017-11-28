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
    this.checkCredentials();
  }

  login(email: string, password: string): Promise<boolean>{
    const params = new URLSearchParams();
    params.append('username', email);
    params.append('password', password);
    params.append('grant_type','password');
    params.append('client_id',environment.clientId);

    const headers = new Headers({
      'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      'Authorization': 'Basic '+ btoa(`${environment.clientId}:${environment.clientSecret}`)
    });

    const options = new RequestOptions({ headers: headers });

    return new Promise<boolean>(resolve => {
      this.http.post(environment.authUrl, params.toString(), options)
        .subscribe(data =>{
          this.saveToken(data.json());

          this.getUser(email).then(result => resolve(result));
      }, err => resolve(false));
    });
  }

  logout(): void {
    this.logged = false;
    this.user = null;
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    localStorage.removeItem('token_expires');

    this.router.navigate(['/login']);
  }

  saveToken(token): void {
    const expireDate = new Date().getTime() + (1000 * token.expires_in);
    console.log(token);
    console.log(token.access_token);
    localStorage.setItem('token', token.access_token);
    localStorage.setItem('token_expires', String(expireDate));
  }

  token(): string {
    const expiry = Number(localStorage.getItem('token_expires'));

    if(this.logged){
      console.log(expiry);
    }

    if(this.logged && new Date().getTime() < expiry) {
      console.log('token = ' + localStorage.getItem('token'));
      return localStorage.getItem('token');
    }
    else {
      console.log('logout');
      this.logout();
      this.router.navigate(['/login']);
      return null;
    }
  }

  getUser(email: string): Promise<boolean> {

    const headers = new Headers({
       'Authorization': 'Bearer '+ localStorage.getItem('token')
    });

    const options = new RequestOptions({ headers: headers });

    return new Promise<boolean>(resolve => {

      this.http.get(environment.apiHost + '/api/user/me' , options).subscribe(response => {
        console.log(response);
        this.user = response.json();
        console.log(this.user);
        this.logged = true;
        localStorage.setItem('user', JSON.stringify(this.user));

        resolve(true);

      }, err => resolve(false));
    });
  }

  checkCredentials(){

    const user = JSON.parse(localStorage.getItem('user'));
    const expire = Number(localStorage.getItem('token_expires'));

    if(user && expire < new Date().getTime()){

      this.logged = true;
      this.user = user;

    } else this.logged = false;
  }

  canActivate() {

    return this.logged;
  }

}
