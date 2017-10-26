import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LunchListComponent } from './lunch-list/lunch-list.component';
import { TileComponent } from './tile/tile.component';
import { WallService } from './wall.service';
import { ExpandedTileComponent } from './expanded-tile/expanded-tile.component';
import { AddMinutesPipe } from '../add-minutes.pipe';
import { OrderComponent } from './expanded-tile/order/order.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [LunchListComponent, TileComponent, ExpandedTileComponent, AddMinutesPipe, OrderComponent],
  providers: [WallService, AddMinutesPipe]
})
export class WallModule { }
