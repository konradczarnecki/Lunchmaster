import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BillingComponent } from './billing.component';
import {BillingService} from "./service/billing.service";
import { MatButtonModule } from '@angular/material';
import { BillingDetailsComponent } from './billing-details/billing-details.component';

@NgModule({
  imports: [
    CommonModule,
    MatButtonModule
  ],
  declarations: [
    BillingComponent,
    BillingDetailsComponent
  ],
  providers : [ BillingService ]
})
export class BillingModule { }
