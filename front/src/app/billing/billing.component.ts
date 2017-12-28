import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../theme/theme.service";
import {BillingService} from "./billing.service";
import {Balance} from "../model";

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.scss']
})
export class BillingComponent implements OnInit {

  balance: Balance;

  constructor(public theme: ThemeService, private billingService: BillingService) { }

  ngOnInit() {

    this.billingService.getBilling().then(balance => {

      this.balance = balance;
    });
  }

  ordersTotal(): number {


  }

}
