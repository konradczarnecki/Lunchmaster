import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../theme/theme.service";

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.scss']
})
export class BillingComponent implements OnInit {

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }

}
