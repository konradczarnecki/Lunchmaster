import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ThemeService } from '../theme/theme.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  mail: string;
  password: string;

  invalidCredentials: boolean;

  constructor(public theme: ThemeService,
              private service: LoginService,
              private router: Router) { }

  ngOnInit() {

    this.invalidCredentials = false;
  }

  login(): void {

    this.service.login(this.mail, this.password).then(result => {

      if(result) this.router.navigate(['/wall']);
      else this.invalidCredentials = true;
    });
  }
}
