import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Lunch } from '../../model';
import {environment} from '../../../environments/environment';

@Injectable()
export class WallService {

  constructor(private http: Http) { }

  getLunches(): Promise<Lunch[]> {

    return new Promise<Lunch[]>(resolve => {

      this.http.get(`${environment.apiHost}/api/lunch/list`).toPromise().then(response => resolve(response.json()));
    });

  }

}
