import {async, ComponentFixture, fakeAsync, inject, TestBed, tick} from '@angular/core/testing';

import { ExpandedTileComponent } from './expanded-tile.component';
import {AddMinutesPipe} from "../../add-minutes.pipe";
import {OrderComponent} from "./order/order.component";
import {WallService} from "../wall.service";
import {BaseRequestOptions, Http, HttpModule, XHRBackend} from "@angular/http";
import {HttpBackend} from "@angular/common/http";
import {Lunch, mockLunches} from "../../model";


describe('ExpandedTileComponent', () => {
  let component: ExpandedTileComponent;
  let fixture: ComponentFixture<ExpandedTileComponent>;
  let service: WallService;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      imports : [HttpModule],
      declarations: [ ExpandedTileComponent, AddMinutesPipe, OrderComponent],
      providers : [WallService]
    })
    .compileComponents();
  }));

  beforeEach(async(() => {

    fixture = TestBed.createComponent(ExpandedTileComponent);
    component = fixture.componentInstance;
    service = TestBed.get(WallService);

    spyOn(service, 'getLunches').and.returnValue(new Promise<Lunch[]>((resolve, reject) => {
      resolve(mockLunches);
    }));

    service.getLunches().then(response => {
      component.lunch = response[0];
      console.log(response);
    })
  }));


  it('should be created', () => {

    fixture.detectChanges();
    expect(component).toBeTruthy();

  });

});
