import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../theme/theme.service";
import {Theme, themes} from '../theme/themes'

@Component({
  selector: 'app-topbar',
  templateUrl: './topbar.component.html',
  styleUrls: ['./topbar.component.scss']
})
export class TopbarComponent implements OnInit {

  themes: Theme[];

  constructor(private theme: ThemeService) { }

  ngOnInit() {

    this.themes = themes;
  }

}
