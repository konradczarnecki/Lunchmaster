import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ThemeService } from '../theme/theme.service';
import { LoginService } from './login.service';
import { MatButton } from "@angular/material";

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
              public service: LoginService,
              public router: Router) { }

  ngOnInit() {

    this.invalidCredentials = false;

    this.mail = 'guest@guest.com';
    this.password = 'guest';
    this.login();
  }

  login(): void {

    this.service.login(this.mail, this.password).then(result => {

        if(result) this.router.navigate(['/wall']);
        else this.invalidCredentials = true;
    });
  }

  register(): void {

    this.router.navigate(['/register']);
  }
}
