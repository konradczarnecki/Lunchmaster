import {Injectable } from "@angular/core";
import 'rxjs/add/operator/toPromise';

import { Lunch } from '../model';
import {Http, Response} from "@angular/http";

@Injectable()
export class WallService{

  constructor(protected http: Http) {
  }

  getLunches(): Promise<Lunch[]> {

    let host: string = false ? window.location.host : 'localhost:1337';

    return new Promise<Lunch[]>(resolve => {

      this.http.get(`http://${host}/api/lunch/list`).toPromise().then(response => resolve(response.json()))
    });

  }
}

