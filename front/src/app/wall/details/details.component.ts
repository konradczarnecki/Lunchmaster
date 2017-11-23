import {Component, Input, OnInit, Output, EventEmitter, ChangeDetectorRef, ViewChild, ElementRef} from '@angular/core';
import { ThemeService } from '../../theme/theme.service';
import { Dish, Lunch, Order} from '../../model';
import { WallService } from '../service/wall.service';
import { LoginService } from '../../login/login.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss'],
})
export class DetailsComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;
  @Output() close = new EventEmitter<boolean>();
  @Output() refresh = new EventEmitter<boolean>();
  @Output() edit = new EventEmitter<Lunch>();

  @ViewChild('orderDetails') orderDetails: ElementRef;

  orderDetailsIndex: number;
  orderInput: string;
  dishList: Dish[];

  constructor(public theme: ThemeService,
              public service: WallService,
              public loginService: LoginService,
              public changeDetector: ChangeDetectorRef) { }

  ngOnInit() {

    this.dishList = [];
    this.orderDetailsIndex = -1;
  }

  total(): number {

    let total = 0;
    for(const dish of this.dishList) total += dish.price;
    return total;
  }

  activeOrder(): Order {

    if(this.orderDetailsIndex < 0) return null;
    else return this.lunch.orders[this.orderDetailsIndex];
  }

  userIsLunchmaster(): boolean {

    if(this.lunch === undefined) return false;
    return this.loginService.user.id === this.lunch.lunchMaster.id;
  }

  deleteLunch(){

    this.service.deleteLunch(this.lunch.id).then(result => {

      if(result){

        this.close.emit(true);
        this.refresh.emit(true);
      }
    });
  }

  editLunch(){

    this.edit.emit(this.lunch);
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

  placeOrder(): void {

    let order: Order = this.lunch.orders.find(ord => this.loginService.user.id === ord.user.id);

    if(order) order.dishes.push(...this.dishList);

    else order = {

      id : null,
      user : {
        id : this.loginService.user.id
      },
      dishes : this.dishList,
      lunchId : this.lunch.id
    };

    this.service.placeOrder(order).then(result => {

      if(result){

        this.refresh.emit(true);
        this.dishList = [];
      }
    });
  }

  showOrderDetails(index: number) {

    this.orderDetailsIndex = index;
    this.changeDetector.detectChanges();

    const buttonRect = document.getElementById('order' + index).getBoundingClientRect();
    const buttonRightEdge = buttonRect.right;
    const detailsLeftEdge = document.getElementById('frame').getBoundingClientRect().left;
    const xOffset = buttonRightEdge - detailsLeftEdge + 10;

    this.orderDetails.nativeElement.style.top = buttonRect.top + 'px';
    this.orderDetails.nativeElement.style.left = xOffset  + 'px';
  }

  hideOrderDetails() {

    this.orderDetailsIndex = -1;
  }

  orderDetailsTotal() {

    let sum = 0;
    for(const dish of this.lunch.orders[this.orderDetailsIndex].dishes) sum += dish.price;
    return sum;
  }

  deleteOrder(index: number){

    if(this.orderBelongsToUser(index))
      this.service.deleteOrder(this.lunch.orders[index].id).then(result => {

        if(result){

          this.hideOrderDetails();
          this.changeDetector.detectChanges();

          this.refresh.emit(true);
        }
      });
  }

  orderBelongsToUser(index: number): boolean {

    return this.lunch.orders[index].user.id === this.loginService.user.id;
  }
}
