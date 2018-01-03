export interface Lunch {

  id: number;
  restaurant: Restaurant;
  lunchMaster: User;
  orders: Order[];
  deadline: Date;
  expectedDelivery: number;
  status: string;
}

export interface Restaurant {

  id: number;
  name: string;
  description: string;
  phone: string;
  address: string;
  link: string;
  logo: string;
  avgDeliveryTime: number;
  dishes?: Dish[];
}

export interface Dish {

  id: number;
  name: string;
  price: number;
  img: string;
  restaurantId: number;
}

export interface User {

  id?: number;
  firstName?: string;
  lastName?: string;
  bankAccount?: string;
  email?: string;
  password?: string;
  mobile?: string;
  part?: string;
  group?: string;
  team?: string;
  floor?: number;
}

export interface Order {

  id: number;
  lunchId: number;
  user: User;
  dishes: Dish[];
}

export interface Response {

  status: string;
  content: any;
}

export interface ThinOrder {

  id: number;
  userId: number;
  userFirstName: number;
  userLastName: number;
  lunchId: number;
  date: Date;
  restaurantName: string;
  dishes: ThinDish[];
}

export interface ThinDish {

  id: number;
  dishName: string;
  price: number;
}

export interface Balance {

  orders_INeedToPay: ThinOrder[];
  orders_IMustGetPaid: ThinOrder[];
}
