import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { ThemeService } from '../../theme/theme.service';
import { Dish, Lunch} from '../../model';
import { WallService } from '../service/wall.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;
  @Output() close = new EventEmitter<boolean>();

  orderInput: string;

  dishList: Dish[];

  constructor(public theme: ThemeService, public service: WallService) { }

  ngOnInit() {

    this.dishList = [];
  }

  get total(): number {

    let total = 0;
    for(const dish of this.dishList) total += dish.price;
    return total;
  }

  clickClose(): void {

    this.close.emit(true);
  }

  addDish(): void {

    const chosenDish = this.lunch.restaurant.dishes.find(dish => dish.name === this.orderInput);
    if(chosenDish != null) this.dishList.push(chosenDish);
    this.orderInput = '';
  }

  removeDish(index: number): void {

    this.dishList.splice(index, 1);
  }
}
