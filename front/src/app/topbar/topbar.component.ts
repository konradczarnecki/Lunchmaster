  import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../theme/theme.service";
import {Theme, themes} from '../theme/themes'
  import {LoginService} from "../login/login.service";

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent implements OnInit {

  themes: Theme[];

  constructor(public theme: ThemeService,
              public loginService: LoginService) { }

  ngOnInit() {

    this.themes = themes;
  }

}
