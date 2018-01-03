import { Component, OnInit } from '@angular/core';
import {ThemeService} from "../theme/theme.service";
import {BillingService} from "./service/billing.service";
import {Balance, ThinOrder} from "../model";

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.scss']
})
export class BillingComponent implements OnInit {

  debtors: ThinOrder[][];
  lenders: ThinOrder[][];
  ordersToShow: ThinOrder[];

  constructor(public theme: ThemeService, private billingService: BillingService) { }

  ngOnInit() {

    this.debtors = [];
    this.lenders = [];
    this.ordersToShow = null;
    this.fetchBilling();
  }

  fetchBilling(): void {

    this.billingService.getBilling().then(balance => {

      const debtors = new Map<number, ThinOrder[]>();
      const lenders = new Map<number, ThinOrder[]>();

      for(const ord of balance.orders_IMustGetPaid) {

        if(debtors.has(ord.userId)) debtors.get(ord.userId).push(ord);
        else debtors.set(ord.userId, [ord]);
      }

      debtors.forEach((value, key) => this.debtors.push(value));

      for(const ord of balance.orders_INeedToPay) {

        if(lenders.has(ord.userId)) lenders.get(ord.userId).push(ord);
        else lenders.set(ord.userId, [ord]);
      }

      lenders.forEach((value, key) => this.lenders.push(value));

    });
  }

  ordersTotal(orders: ThinOrder[]): number {

    let sum = 0;

    for(const order of orders)
      for(const dish of order.dishes)
        sum += dish.price;

    return sum;
  }

  setOrdersToShow(orders: ThinOrder[]): void {

    this.ordersToShow = orders;
  }

}
