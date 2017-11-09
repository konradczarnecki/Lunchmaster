import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  @ViewChild('wrapper') wrapper: ElementRef;

  constructor(private router: Router) {}

  ngOnInit() {

    if(location.pathname === '/') this.router.navigate(['/wall']);
    this.wrapper.nativeElement.style.backgroundImage = `url('/assets/images/back${Math.floor(1 + Math.random() * 5)}.png')`;
  }
}
