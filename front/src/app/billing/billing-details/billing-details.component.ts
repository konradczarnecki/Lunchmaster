import {Component, Input, OnInit} from '@angular/core';
import {ThemeService} from "../../theme/theme.service";
import {ThinOrder} from "../../model";

@Component({
  selector: 'app-billing-details',
  templateUrl: './billing-details.component.html',
  styleUrls: ['./billing-details.component.scss']
})
export class BillingDetailsComponent implements OnInit {

  @Input('orders') orders: ThinOrder[];

  constructor(public theme: ThemeService) { }

  ngOnInit() {
  }

}
