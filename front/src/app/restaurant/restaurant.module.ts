import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {RestaurantsComponent} from "./restaurants.component";
import {RestaurantService} from "./service/restaurant.service";
import {RestaurantTileComponent} from "./retaurant-tile/restaurant-tile.component";
import {EditRestaurantComponent} from "./edit-restaurant/edit-restaurant.component";
import {RestaurantDetailsComponent} from "./restaurant-details/restaurant-details.component";


@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [ RestaurantsComponent, RestaurantTileComponent, EditRestaurantComponent, RestaurantDetailsComponent ],
  providers: [ RestaurantService ]
})
export class RestaurantModule { }
