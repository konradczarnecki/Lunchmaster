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
  logo: string;
  phone: string;
  address: string;
  link: string;
  description: string;
  avgDeliveryTime: number;
  dishes: Dish[];
}

export interface Dish {

  id: number;
  name: string;
  price: number;
  img: string;
  images: string[];
}

export interface User {

  id: number;
  firstName: string;
  lastName: string;
  bankAccount: string;
  email: string;
  mobile: string;
  part: string;
  group: string;
  team: string;
  floor: number;
}

export interface Order {

  id: number;
  user: User;
  dish: Dish[];
}

export const mockLunches: any[] = [{"id":1,"restaurant":{"id":1,"name":"Chmielarnia","logo":"https://static.pyszne.pl/images/restaurants/pl/53R3NQ3/logo_465x320.png","phone":"611 111 222","address":null,"link":null,"description":null,"avgDeliveryTime":60,"dishes":[{"id":1,"name":"Sample dish 1","price":1.0,"img":"img","images":[]}]},"lunchMaster":{"id":1,"firstName":"Janusz","lastName":"Kowalski","email":"jan.kowalski@nowhere.com","mobile":"666 777 888","part":"PART 1","group":"GROUP 1","team":"TEAM 1","bankAccount":"12 1111 2222 3333 4444 5555 6666","floor":13},"orders":[{"id":31,"user":{"id":1,"firstName":"Janusz","lastName":"Kowalski","email":"jan.kowalski@nowhere.com","mobile":"666 777 888","part":"PART 1","group":"GROUP 1","team":"TEAM 1","bankAccount":"12 1111 2222 3333 4444 5555 6666","floor":13},"dish":[{"id":1,"name":"Sample dish 1","price":1.0,"img":"img","images":[]}]},{"id":31,"user":{"id":1,"firstName":"Janusz","lastName":"Kowalski","email":"jan.kowalski@nowhere.com","mobile":"666 777 888","part":"PART 1","group":"GROUP 1","team":"TEAM 1","bankAccount":"12 1111 2222 3333 4444 5555 6666","floor":13},"dish":[{"id":1,"name":"Sample dish 1","price":1.0,"img":"img","images":[]}]},{"id":31,"user":{"id":1,"firstName":"Janusz","lastName":"Kowalski","email":"jan.kowalski@nowhere.com","mobile":"666 777 888","part":"PART 1","group":"GROUP 1","team":"TEAM 1","bankAccount":"12 1111 2222 3333 4444 5555 6666","floor":13},"dish":[{"id":1,"name":"Sample dish 1","price":1.0,"img":"img","images":[]}]}],"status":"open","deadline":1506708812487,"expectedDelivery":60}];
