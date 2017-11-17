import { Component, OnInit } from '@angular/core';

import { ThemeService } from '../theme/theme.service';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private theme: ThemeService, private service: LoginService) { }

  ngOnInit() {
  }

}