import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'addMinutes'
})
export class AddMinutesPipe implements PipeTransform {

  transform(date: any, minutes: number): Date {

    return new Date(date + minutes * 60000);
  }
}
