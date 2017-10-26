import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LunchListComponent } from './lunch-list.component';
import {TileComponent} from "../tile/tile.component";
import {WallService} from "../wall.service";
import {Lunch, mockLunches} from "../../model";
import {AddMinutesPipe} from "../../add-minutes.pipe";
import {ExpandedTileComponent} from "../expanded-tile/expanded-tile.component";
import {OrderComponent} from "../expanded-tile/order/order.component";
import {HttpModule} from "@angular/http";
import {WallModule} from "../wall.module";

describe('LunchListComponent', () => {
  let component: LunchListComponent;
  let fixture: ComponentFixture<LunchListComponent>;
  let service: WallService;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      imports : [HttpModule, WallModule],
      declarations: [],
      providers : [WallService]
    })
    .compileComponents();
  }));

  beforeEach(() => {

    fixture = TestBed.createComponent(LunchListComponent);
    component = fixture.componentInstance;
    service = TestBed.get(WallService);

    spyOn(service, 'getLunches').and.returnValue(new Promise<Lunch[]>((resolve, reject) => {
      resolve(mockLunches);
    }));

  });

  it('should be created', () => {

    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  it('gets lunches list', () => {

    component.ngOnInit();
    fixture.detectChanges();
    expect(component.tiles).toBeTruthy();
  })
});
