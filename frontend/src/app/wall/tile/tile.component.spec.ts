import {async, ComponentFixture, fakeAsync, TestBed, tick} from '@angular/core/testing';

import { TileComponent } from './tile.component';
import {WallModule} from "../wall.module";
import {WallService} from "../wall.service";
import {Lunch, mockLunches} from "../../model";
import {AddMinutesPipe} from "../../add-minutes.pipe";
import {HttpModule} from "@angular/http";
import {windowWhen} from "rxjs/operator/windowWhen";
import anime from 'animejs';

describe('TileComponent', () => {
  let component: TileComponent;
  let fixture: ComponentFixture<TileComponent>;
  let service: WallService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [WallModule, HttpModule],
      declarations: [ ],
    })
    .compileComponents();
  }));

  beforeEach(async(() => {
    fixture = TestBed.createComponent(TileComponent);
    component = fixture.componentInstance;

    service = TestBed.get(WallService);

    spyOn(service, 'getLunches').and.returnValue(new Promise<Lunch[]>((resolve, reject) => {
      resolve(mockLunches);
    }));

    service.getLunches().then(lunches => component.lunch = lunches[0]);
  }));


  it('should be created', () => {

    fixture.detectChanges();
    expect(component).toBeTruthy();
  });

  it('should be created with appropriate state', () => {

    fixture.detectChanges();
    expect(component.clickable).toBeTruthy();
    expect(component.clicked).toBeFalsy();
    expect(component.expanded).toBeFalsy();

    expect(component.lunch).toBeTruthy();
    expect(component.image).toBeTruthy();

    expect(window.getComputedStyle(component.collapsedContent.nativeElement).getPropertyValue('opacity'))
      .toBeGreaterThan(0.5);
  });

});
