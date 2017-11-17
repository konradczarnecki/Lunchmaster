import { Component, OnInit } from '@angular/core';

import { LoginService } from '../login/login.service';
import { ThemeService } from '../theme/theme.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(public theme: ThemeService, private loginService: LoginService) { }

  ngOnInit() {
  }

  logout(){

    this.loginService.logout();
  }

}
