import { Component, OnInit } from '@angular/core';

import { ThemeService } from '../theme/theme.service';
import { LoginService } from '../login/login.service';
import { themes } from '../theme/theme.service';

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent implements OnInit {

  themes: string[];
  pages: string[];

  constructor(public theme: ThemeService,
              public loginService: LoginService) { }

  ngOnInit() {

    this.themes = themes;
    this.pages = ['wall', 'billing', 'restaurants', 'profile'];
  }
}
