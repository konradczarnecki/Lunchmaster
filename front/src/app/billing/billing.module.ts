import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BillingComponent } from './billing.component';
import {BillingService} from "./billing.service";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    BillingComponent
  ],
  providers : [ BillingService ]
})
export class BillingModule { }
