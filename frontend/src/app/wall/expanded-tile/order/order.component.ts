import {Component, Input, OnInit} from '@angular/core';
import {Order} from "../../../model";

@Component({
  selector: 'order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  @Input('order') order: Order;

  constructor() { }

  ngOnInit() {
  }

}
