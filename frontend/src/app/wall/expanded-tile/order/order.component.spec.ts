import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpModule } from "@angular/http";

import { OrderComponent } from './order.component';
import { WallService } from "../../wall.service";
import {Lunch, mockLunches, Order} from "../../../model";

describe('OrderComponent', () => {

  let component: OrderComponent;
  let fixture: ComponentFixture<OrderComponent>;
  let service: WallService;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      imports : [HttpModule],
      declarations: [OrderComponent],
      providers : [WallService]
    })
    .compileComponents();
  }));

  beforeEach(async(() => {

    fixture = TestBed.createComponent(OrderComponent);
    component = fixture.componentInstance;
    service = TestBed.get(WallService);

    spyOn(service, 'getLunches').and.returnValue(new Promise<Lunch[]>((resolve, reject) => {
      resolve(mockLunches);
    }));

    service.getLunches().then(lunches => component.order = lunches[0].orders[0]);

  }));

  it('should be created', () => {

    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

});

