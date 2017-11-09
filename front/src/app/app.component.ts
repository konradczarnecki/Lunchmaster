import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import {ThemeService} from "./theme/theme.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(private router: Router, private theme: ThemeService) {}

  ngOnInit() {

    if(location.pathname === '/') this.router.navigate(['/wall']);
  }
}
