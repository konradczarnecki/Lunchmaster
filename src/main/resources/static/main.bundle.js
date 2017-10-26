webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	return new Promise(function(resolve, reject) { reject(new Error("Cannot find module '" + req + "'.")); });
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/add-minutes.pipe.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AddMinutesPipe; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AddMinutesPipe = (function () {
    function AddMinutesPipe() {
    }
    AddMinutesPipe.prototype.transform = function (date, minutes) {
        return new Date(date + minutes * 60000);
    };
    return AddMinutesPipe;
}());
AddMinutesPipe = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["X" /* Pipe */])({
        name: 'addMinutes'
    })
], AddMinutesPipe);

//# sourceMappingURL=add-minutes.pipe.js.map

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"wrapper\">\r\n  <topbar class=\"topbar\"></topbar>\r\n  <div class=\"content\">\r\n    <router-outlet></router-outlet>\r\n  </div>\r\n</div>"

/***/ }),

/***/ "../../../../../src/app/app.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".wrapper {\n  position: absolute;\n  top: 0;\n  left: 0;\n  width: 100%;\n  min-height: 100%;\n  overflow: hidden;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-rows: 60px 1fr;\n      grid-template-rows: 60px 1fr;\n  grid-template-areas: \"topbar\" \"main\";\n  -webkit-box-align: stretch;\n      -ms-flex-align: stretch;\n          align-items: stretch;\n  -ms-grid-column-align: stretch;\n      justify-items: stretch; }\n\n.topbar {\n  grid-area: topbar; }\n\n.content {\n  grid-area: main; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
    }
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html"),
        styles: [__webpack_require__("../../../../../src/app/app.component.scss")]
    })
], AppComponent);

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export routes */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__wall_wall_module__ = __webpack_require__("../../../../../src/app/wall/wall.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__topbar_topbar_component__ = __webpack_require__("../../../../../src/app/topbar/topbar.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__wall_lunch_list_lunch_list_component__ = __webpack_require__("../../../../../src/app/wall/lunch-list/lunch-list.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var routes = [
    { path: '', component: __WEBPACK_IMPORTED_MODULE_7__wall_lunch_list_lunch_list_component__["a" /* LunchListComponent */] }
];
var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["M" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_6__topbar_topbar_component__["a" /* TopbarComponent */],
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["a" /* RouterModule */].forRoot(routes),
            __WEBPACK_IMPORTED_MODULE_3__angular_http__["b" /* HttpModule */],
            __WEBPACK_IMPORTED_MODULE_4__wall_wall_module__["a" /* WallModule */]
        ],
        providers: [],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/model.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Lunch; });
/* unused harmony export Restaurant */
/* unused harmony export Dish */
/* unused harmony export User */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return Order; });
/* unused harmony export mockLunches */
/**
 * Created by k.czarnecki on 2017-09-26.
 */
var Lunch = (function () {
    function Lunch() {
    }
    Lunch.prototype.track = function () {
        return this.id;
    };
    return Lunch;
}());

var Restaurant = (function () {
    function Restaurant() {
    }
    return Restaurant;
}());

var Dish = (function () {
    function Dish() {
    }
    return Dish;
}());

var User = (function () {
    function User() {
    }
    return User;
}());

var Order = (function () {
    function Order() {
    }
    return Order;
}());

var mockLunches = [{ "id": 1, "restaurant": { "id": 1, "name": "Chmielarnia", "logo": "https://static.pyszne.pl/images/restaurants/pl/53R3NQ3/logo_465x320.png", "phone": "611 111 222", "address": null, "link": null, "description": null, "avgDeliveryTime": 60, "dishes": [{ "id": 1, "name": "Sample dish 1", "price": 1.0, "img": "img", "images": [] }] }, "lunchMaster": { "id": 1, "firstName": "Janusz", "lastName": "Kowalski", "email": "jan.kowalski@nowhere.com", "mobile": "666 777 888", "part": "PART 1", "group": "GROUP 1", "team": "TEAM 1", "bankAccount": "12 1111 2222 3333 4444 5555 6666", "floor": 13 }, "orders": [{ "id": 31, "user": { "id": 1, "firstName": "Janusz", "lastName": "Kowalski", "email": "jan.kowalski@nowhere.com", "mobile": "666 777 888", "part": "PART 1", "group": "GROUP 1", "team": "TEAM 1", "bankAccount": "12 1111 2222 3333 4444 5555 6666", "floor": 13 }, "dish": [{ "id": 1, "name": "Sample dish 1", "price": 1.0, "img": "img", "images": [] }] }, { "id": 31, "user": { "id": 1, "firstName": "Janusz", "lastName": "Kowalski", "email": "jan.kowalski@nowhere.com", "mobile": "666 777 888", "part": "PART 1", "group": "GROUP 1", "team": "TEAM 1", "bankAccount": "12 1111 2222 3333 4444 5555 6666", "floor": 13 }, "dish": [{ "id": 1, "name": "Sample dish 1", "price": 1.0, "img": "img", "images": [] }] }, { "id": 31, "user": { "id": 1, "firstName": "Janusz", "lastName": "Kowalski", "email": "jan.kowalski@nowhere.com", "mobile": "666 777 888", "part": "PART 1", "group": "GROUP 1", "team": "TEAM 1", "bankAccount": "12 1111 2222 3333 4444 5555 6666", "floor": 13 }, "dish": [{ "id": 1, "name": "Sample dish 1", "price": 1.0, "img": "img", "images": [] }] }], "status": "open", "deadline": 1506708812487, "expectedDelivery": 60 }];
//# sourceMappingURL=model.js.map

/***/ }),

/***/ "../../../../../src/app/topbar/topbar.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"topbar\"></div>"

/***/ }),

/***/ "../../../../../src/app/topbar/topbar.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".topbar {\n  width: 100%;\n  height: 100%;\n  background: rgba(78, 124, 209, 0.61);\n  box-shadow: 0px 5px 10px 3px rgba(105, 105, 105, 0.2); }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/topbar/topbar.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TopbarComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var TopbarComponent = (function () {
    function TopbarComponent() {
    }
    TopbarComponent.prototype.ngOnInit = function () {
    };
    return TopbarComponent;
}());
TopbarComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'topbar',
        template: __webpack_require__("../../../../../src/app/topbar/topbar.component.html"),
        styles: [__webpack_require__("../../../../../src/app/topbar/topbar.component.scss")]
    }),
    __metadata("design:paramtypes", [])
], TopbarComponent);

//# sourceMappingURL=topbar.component.js.map

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/expanded-tile.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"wrapper\">\r\n\r\n  <div class=\"mainColumn\">\r\n\r\n    <div class=\"lunchmasterBox\">\r\n      <span>Lunchmaster:</span>\r\n      <span class=\"name\">{{lunch.lunchMaster.firstName}} {{lunch.lunchMaster.lastName}}</span>\r\n    </div>\r\n\r\n    <div class=\"lunchmasterInfo\">\r\n      <span>Phone: {{lunch.lunchMaster.mobile}}</span>\r\n      <span style=\"margin-left: 15px\">Bank: {{lunch.lunchMaster.bankAccount}}</span>\r\n      <!--<span style=\"margin-left: 15px\">Floor: {{lunch.lunchMaster.floor}}</span>-->\r\n    </div>\r\n\r\n    <div class=\"hoursBox\">\r\n      <span class=\"hoursLabel\">Order deadline:</span>\r\n      <span class=\"hoursLabel\">Expected delivery:</span>\r\n      <span class=\"hours\">{{lunch.deadline | date:'HH:mm'}}</span>\r\n      <span class=\"hours\">{{lunch.deadline | addMinutes: lunch.expectedDelivery | date:'HH:mm'}}</span>\r\n    </div>\r\n\r\n    <div class=\"empty\"></div>\r\n\r\n    <order class=\"listPosition\" *ngFor=\"let order of lunch.orders; let i = index\" [order]=\"order\" (click)=\"clicked(i)\"></order>\r\n\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/expanded-tile.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".wrapper {\n  width: 100%;\n  height: 65%;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: 1fr 90% 1fr;\n      grid-template-columns: 1fr 90% 1fr;\n  grid-template-areas: \"margin-left main margin-right\"; }\n\n.mainColumn {\n  grid-area: main;\n  font-size: 12px;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: 60% 40%;\n      grid-template-columns: 60% 40%;\n  -ms-grid-rows: 50px 30px 20px;\n      grid-template-rows: 50px 30px 20px;\n  grid-auto-rows: 40px;\n  grid-row-gap: 5px; }\n\n.lunchmasterBox {\n  -ms-grid-column: 1;\n      grid-column: 1;\n  -ms-grid-row: 1;\n      grid-row: 1;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-rows: 50% 1fr;\n      grid-template-rows: 50% 1fr;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center; }\n\n.lunchmasterInfo {\n  -ms-grid-column: span 2;\n      grid-column: span 2;\n  -ms-flex-item-align: center;\n      -ms-grid-row-align: center;\n      align-self: center;\n  -webkit-transform: translate(0, 10px);\n          transform: translate(0, 10px); }\n\n.name {\n  font-size: 26px; }\n\n.hoursBox {\n  -ms-grid-column: 2;\n      grid-column: 2;\n  -ms-grid-row: 1;\n      grid-row: 1;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-rows: 50% 1fr;\n      grid-template-rows: 50% 1fr;\n  -ms-grid-columns: 1fr 1fr;\n      grid-template-columns: 1fr 1fr;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  -ms-grid-column-align: center;\n      justify-items: center; }\n\n.hoursLabel {\n  text-align: center; }\n\n.hours {\n  font-size: 26px;\n  -ms-flex-item-align: baseline;\n      align-self: baseline; }\n\n.listPosition {\n  -ms-grid-column: span 2;\n      grid-column: span 2;\n  border: solid 1px rgba(134, 135, 153, 0.41);\n  border-radius: 2px;\n  margin: 0 25px;\n  padding-left: 15px;\n  font-size: 105%;\n  display: -ms-grid;\n  display: grid;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center; }\n\n.listPosition:hover {\n  cursor: pointer;\n  background-color: rgba(78, 124, 209, 0.61); }\n\n@media screen and (max-width: 600px), screen and (max-width: 6cm) {\n  .mainColumn {\n    font-size: 6.66666667px; }\n  .hours, .name {\n    font-size: 11.81818182px; } }\n\n@media screen and (max-width: 1300px), screen and (max-width: 20cm) {\n  .mainColumn {\n    font-size: 10px; }\n  .hours, .name {\n    font-size: 21.66666667px; } }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/expanded-tile.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ExpandedTileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__model__ = __webpack_require__("../../../../../src/app/model.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var ExpandedTileComponent = (function () {
    function ExpandedTileComponent() {
    }
    ExpandedTileComponent.prototype.ngOnInit = function () {
    };
    ExpandedTileComponent.prototype.clicked = function (index) {
    };
    return ExpandedTileComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__model__["a" /* Lunch */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__model__["a" /* Lunch */]) === "function" && _a || Object)
], ExpandedTileComponent.prototype, "lunch", void 0);
ExpandedTileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'expanded-tile',
        template: __webpack_require__("../../../../../src/app/wall/expanded-tile/expanded-tile.component.html"),
        styles: [__webpack_require__("../../../../../src/app/wall/expanded-tile/expanded-tile.component.scss")]
    }),
    __metadata("design:paramtypes", [])
], ExpandedTileComponent);

var _a;
//# sourceMappingURL=expanded-tile.component.js.map

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/order/order.component.html":
/***/ (function(module, exports) {

module.exports = "<div>\r\n  <span>{{order.user.firstName}} {{order.user.lastName}}</span>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/order/order.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/wall/expanded-tile/order/order.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return OrderComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__model__ = __webpack_require__("../../../../../src/app/model.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var OrderComponent = (function () {
    function OrderComponent() {
    }
    OrderComponent.prototype.ngOnInit = function () {
    };
    return OrderComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])('order'),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__model__["b" /* Order */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__model__["b" /* Order */]) === "function" && _a || Object)
], OrderComponent.prototype, "order", void 0);
OrderComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'order',
        template: __webpack_require__("../../../../../src/app/wall/expanded-tile/order/order.component.html"),
        styles: [__webpack_require__("../../../../../src/app/wall/expanded-tile/order/order.component.scss")]
    }),
    __metadata("design:paramtypes", [])
], OrderComponent);

var _a;
//# sourceMappingURL=order.component.js.map

/***/ }),

/***/ "../../../../../src/app/wall/lunch-list/lunch-list.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"wall\" #wall>\r\n  <div class=\"tiles\">\r\n    <tile *ngFor=\"let lunch of lunches; trackBy: track\" [lunch]=\"lunch\" (click)=\"expand(lunch.id)\" (closed)=\"collapse($event)\"></tile>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/wall/lunch-list/lunch-list.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".wall {\n  width: 100%;\n  height: 100%;\n  margin-top: 25px;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: 1fr 65% 1fr;\n      grid-template-columns: 1fr 65% 1fr;\n  grid-template-areas: \"left-margin tiles right-margin\";\n  -webkit-box-align: stretch;\n      -ms-flex-align: stretch;\n          align-items: stretch;\n  -ms-grid-column-align: stretch;\n      justify-items: stretch; }\n  @media screen and (max-width: 600px) {\n    .wall {\n      -ms-grid-columns: 1fr 90% 1fr;\n          grid-template-columns: 1fr 90% 1fr;\n      grid-template-areas: \"left-margin tiles right-margin\"; } }\n\n.tiles {\n  grid-area: tiles;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-columns: (minmax(150px, 1fr))[auto-fill];\n      grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));\n  -ms-grid-rows: (200px)[auto-fill];\n      grid-template-rows: repeat(auto-fill, 200px);\n  grid-auto-columns: 150px;\n  grid-auto-rows: 200px;\n  grid-gap: 20px;\n  -webkit-box-align: stretch;\n      -ms-flex-align: stretch;\n          align-items: stretch;\n  -ms-grid-column-align: stretch;\n      justify-items: stretch; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/wall/lunch-list/lunch-list.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return LunchListComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_animejs__ = __webpack_require__("../../../../animejs/anime.min.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_animejs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_animejs__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__wall_service__ = __webpack_require__("../../../../../src/app/wall/wall.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__tile_tile_component__ = __webpack_require__("../../../../../src/app/wall/tile/tile.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var LunchListComponent = (function () {
    function LunchListComponent(service) {
        this.service = service;
    }
    LunchListComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getLunches().then(function (lunches) {
            _this.lunches = lunches;
        });
        window.onresize = function () { return _this.ngOnInit(); };
    };
    LunchListComponent.prototype.expand = function (id) {
        var chosenTile = this.getTileByLunchId(id);
        if (chosenTile.clicked == true || chosenTile.clickable == false)
            return;
        else
            chosenTile.clicked = true;
        this.getOtherTiles([chosenTile]).forEach(function (tile) { return tile.clickable = false; });
        chosenTile.animateContent('expand');
        this.animateTile('expand', chosenTile);
    };
    LunchListComponent.prototype.collapse = function (id) {
        var chosenTile = this.getTileByLunchId(id);
        this.getOtherTiles([chosenTile]).forEach(function (tile) { return tile.clickable = true; });
        chosenTile.animateContent('collapse');
        this.animateTile('collapse', chosenTile);
    };
    LunchListComponent.prototype.getTileByLunchId = function (id) {
        return this.tiles.toArray().find(function (tile) { return tile.lunch.id == id; });
    };
    LunchListComponent.prototype.getOtherTiles = function (tiles) {
        return this.tiles.filter(function (tile) { return !tiles.includes(tile); });
    };
    LunchListComponent.prototype.getOtherHtmlElements = function (tiles) {
        return this.getOtherTiles(tiles).map(function (component) { return component.tile.nativeElement; });
    };
    LunchListComponent.prototype.animateTile = function (direction, chosenTile) {
        var expanding = direction == 'expand';
        var el = chosenTile.tile.nativeElement;
        var frame = chosenTile.frame.nativeElement;
        var otherElements = this.getOtherHtmlElements([chosenTile]);
        var windowWidth = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
        var windowHeight = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
        var targetWidth, targetHeight, frameHeight;
        if (expanding) {
            targetWidth = windowWidth > windowHeight + 200 ? windowWidth / 2.3 : windowWidth * 0.85;
            targetHeight = windowHeight / 1.1;
            this.baseSize = [el.offsetWidth, el.offsetHeight];
        }
        else {
            targetWidth = this.baseSize[0];
            targetHeight = this.baseSize[1];
        }
        var transX = expanding ? (windowWidth - targetWidth) / 2 - el.offsetLeft : 0;
        var transY = expanding ? window.scrollY + (windowHeight - targetHeight) / 2 - el.offsetTop : 0;
        var targetOpacity = expanding ? 0.2 : 1;
        __WEBPACK_IMPORTED_MODULE_1_animejs___default()({
            targets: el,
            translateX: transX,
            translateY: transY,
            width: targetWidth,
            height: targetHeight,
            easing: 'easeInOutElastic',
            elasticity: 150,
            duration: 1000,
            complete: function () {
                chosenTile.expanded = expanding;
                chosenTile.clicked = expanding;
                // chosenTile.fadeExpandedContent(direction);
            }
        });
        __WEBPACK_IMPORTED_MODULE_1_animejs___default()({
            targets: frame,
            height: targetHeight - 40,
            duration: 1000,
            delay: 500,
            elasticity: 250
        });
        __WEBPACK_IMPORTED_MODULE_1_animejs___default()({
            targets: otherElements,
            opacity: targetOpacity,
            duration: 800,
            easing: 'linear'
        });
    };
    return LunchListComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_17" /* ViewChildren */])(__WEBPACK_IMPORTED_MODULE_3__tile_tile_component__["a" /* TileComponent */]),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["Z" /* QueryList */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["Z" /* QueryList */]) === "function" && _a || Object)
], LunchListComponent.prototype, "tiles", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('wall'),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _b || Object)
], LunchListComponent.prototype, "wall", void 0);
LunchListComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'lunch-list',
        template: __webpack_require__("../../../../../src/app/wall/lunch-list/lunch-list.component.html"),
        styles: [__webpack_require__("../../../../../src/app/wall/lunch-list/lunch-list.component.scss")]
    }),
    __metadata("design:paramtypes", [typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_2__wall_service__["a" /* WallService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__wall_service__["a" /* WallService */]) === "function" && _c || Object])
], LunchListComponent);

var _a, _b, _c;
//# sourceMappingURL=lunch-list.component.js.map

/***/ }),

/***/ "../../../../../src/app/wall/tile/tile.component.html":
/***/ (function(module, exports) {

module.exports = "<div class=\"tile\" [ngClass]=\"{'clicked' : clicked, 'noClick' : !clickable}\" #tile>\r\n\r\n  <div class=\"close\" *ngIf=\"expanded\" (click)=\"close()\">X</div>\r\n  <div class=\"restaurant\">{{lunch.restaurant.name}}</div>\r\n\r\n  <div class=\"content\" #frame>\r\n\r\n    <div class=\"image\" #image>\r\n      <img src=\"{{lunch.restaurant.logo}}\"/>\r\n    </div>\r\n\r\n    <div *ngIf=\"!expanded\" #collapsedContent class=\"inner\">\r\n      <div class=\"lunchmaster\">{{lunch.lunchMaster.firstName}} {{lunch.lunchMaster.lastName}}</div>\r\n\r\n      <div class=\"deadline\">\r\n        <div class=\"label\">Deadline:</div>\r\n        <div class=\"hours\">{{lunch.deadline | date:'HH:mm'}}</div>\r\n      </div>\r\n\r\n      <div class=\"expected\">\r\n        <div class=\"label\">Expected:</div>\r\n        <div class=\"hours\">{{lunch.deadline | addMinutes: lunch.expectedDelivery | date:'HH:mm'}}</div>\r\n      </div>\r\n    </div>\r\n\r\n    <expanded-tile class=\"expandedContent\" *ngIf=\"expanded\" [lunch]=\"lunch\" #expandedContent></expanded-tile>\r\n  </div>\r\n</div>\r\n"

/***/ }),

/***/ "../../../../../src/app/wall/tile/tile.component.scss":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".tile {\n  width: 100%;\n  height: 100%;\n  min-height: 100%;\n  background-color: transparent;\n  border-radius: 4px;\n  font-family: \"Helvetica\";\n  color: rgba(105, 103, 115, 0.91);\n  font-size: 17px;\n  display: -ms-grid;\n  display: grid;\n  -ms-grid-rows: 40px 1fr;\n      grid-template-rows: 40px 1fr;\n  -webkit-box-align: stretch;\n      -ms-flex-align: stretch;\n          align-items: stretch;\n  -ms-grid-column-align: stretch;\n      justify-items: stretch; }\n\n.tile:not(.clicked):hover {\n  cursor: pointer;\n  border-color: rgba(138, 160, 188, 0.39);\n  box-shadow: 2px 2px 3px 1px rgba(114, 114, 114, 0.12); }\n\n.clicked {\n  z-index: 1; }\n\n.close {\n  position: absolute;\n  right: 15px;\n  top: 10px;\n  font-weight: 700;\n  color: white; }\n\n.close:hover {\n  cursor: pointer; }\n\n.content {\n  -ms-grid-row: 2;\n      grid-row: 2;\n  height: 160px;\n  background-color: white;\n  border: solid 1px rgba(134, 135, 153, 0.41);\n  border-radius: 0 0 4px 4px;\n  overflow: hidden; }\n\n.restaurant {\n  -ms-grid-row: 1;\n      grid-row: 1;\n  padding: 10px 0;\n  background: #636fd1;\n  color: white;\n  border: solid 1px #636fd1;\n  border-radius: 4px 4px 0 0;\n  font-weight: 600;\n  text-align: center; }\n\n.image {\n  height: 35%;\n  -ms-grid-row-align: center;\n      align-self: center;\n  display: -ms-grid;\n  display: grid;\n  padding-top: 10px; }\n\nimg {\n  margin: auto;\n  height: 90%;\n  width: 60%; }\n\n.lunchmaster {\n  margin-top: 5px;\n  height: 45px;\n  text-align: center;\n  display: -ms-grid;\n  display: grid;\n  -webkit-box-align: center;\n      -ms-flex-align: center;\n          align-items: center;\n  -ms-grid-column-align: center;\n      justify-items: center; }\n\n.deadline {\n  float: left;\n  margin-left: 15px;\n  text-align: center; }\n\n.expected {\n  float: right;\n  margin-right: 15px;\n  text-align: center; }\n\n.label {\n  font-size: 10px; }\n\n.hours {\n  font-size: 20px; }\n\n.noClick {\n  pointer-events: none; }\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/wall/tile/tile.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return TileComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__model__ = __webpack_require__("../../../../../src/app/model.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_animejs__ = __webpack_require__("../../../../animejs/anime.min.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_animejs___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_animejs__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var TileComponent = (function () {
    function TileComponent(cdRef) {
        this.cdRef = cdRef;
        this.closed = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["x" /* EventEmitter */]();
        this.expanded = false;
        this.clicked = false;
        this.clickable = true;
    }
    TileComponent.prototype.animateContent = function (direction) {
        var expanding = direction == 'expand';
        var targetOp = expanding ? 0 : 1;
        var startOp = expanding ? 1 : 0;
        var imgSize = expanding ? 0.7 : 1;
        var imgTransp = expanding ? -40 : 0;
        this.cdRef.detectChanges();
        __WEBPACK_IMPORTED_MODULE_2_animejs___default()({
            targets: this.collapsedContent.nativeElement,
            opacity: [startOp, targetOp],
            duration: 400,
            easing: 'linear'
        });
        __WEBPACK_IMPORTED_MODULE_2_animejs___default()({
            targets: this.image.nativeElement,
            scale: imgSize,
            translateY: imgTransp,
            duration: 800,
            delay: 500
        });
    };
    TileComponent.prototype.fadeExpandedContent = function (direction) {
        this.cdRef.detectChanges();
        var expanding = direction == 'expand';
        var opTarget = expanding ? 1 : 0;
        __WEBPACK_IMPORTED_MODULE_2_animejs___default()({
            targets: this.expandedContent.nativeElement,
            opacity: [Math.abs(opTarget - 1), opTarget],
            duration: 250,
            easing: 'linear'
        });
    };
    TileComponent.prototype.close = function () {
        this.expanded = false;
        this.closed.emit(this.lunch.id);
    };
    return TileComponent;
}());
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["F" /* Input */])(),
    __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__model__["a" /* Lunch */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__model__["a" /* Lunch */]) === "function" && _a || Object)
], TileComponent.prototype, "lunch", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["T" /* Output */])(),
    __metadata("design:type", Object)
], TileComponent.prototype, "closed", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('tile'),
    __metadata("design:type", typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _b || Object)
], TileComponent.prototype, "tile", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('image'),
    __metadata("design:type", typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _c || Object)
], TileComponent.prototype, "image", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('collapsedContent'),
    __metadata("design:type", typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _d || Object)
], TileComponent.prototype, "collapsedContent", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('expandedContent'),
    __metadata("design:type", typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _e || Object)
], TileComponent.prototype, "expandedContent", void 0);
__decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_16" /* ViewChild */])('frame'),
    __metadata("design:type", typeof (_f = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["v" /* ElementRef */]) === "function" && _f || Object)
], TileComponent.prototype, "frame", void 0);
TileComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'tile',
        template: __webpack_require__("../../../../../src/app/wall/tile/tile.component.html"),
        styles: [__webpack_require__("../../../../../src/app/wall/tile/tile.component.scss")]
    }),
    __metadata("design:paramtypes", [typeof (_g = typeof __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_core__["l" /* ChangeDetectorRef */]) === "function" && _g || Object])
], TileComponent);

var _a, _b, _c, _d, _e, _f, _g;
//# sourceMappingURL=tile.component.js.map

/***/ }),

/***/ "../../../../../src/app/wall/wall.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WallModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_common__ = __webpack_require__("../../../common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__lunch_list_lunch_list_component__ = __webpack_require__("../../../../../src/app/wall/lunch-list/lunch-list.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__tile_tile_component__ = __webpack_require__("../../../../../src/app/wall/tile/tile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__wall_service__ = __webpack_require__("../../../../../src/app/wall/wall.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__expanded_tile_expanded_tile_component__ = __webpack_require__("../../../../../src/app/wall/expanded-tile/expanded-tile.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__add_minutes_pipe__ = __webpack_require__("../../../../../src/app/add-minutes.pipe.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__expanded_tile_order_order_component__ = __webpack_require__("../../../../../src/app/wall/expanded-tile/order/order.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};








var WallModule = (function () {
    function WallModule() {
    }
    return WallModule;
}());
WallModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["M" /* NgModule */])({
        imports: [
            __WEBPACK_IMPORTED_MODULE_1__angular_common__["b" /* CommonModule */]
        ],
        declarations: [__WEBPACK_IMPORTED_MODULE_2__lunch_list_lunch_list_component__["a" /* LunchListComponent */], __WEBPACK_IMPORTED_MODULE_3__tile_tile_component__["a" /* TileComponent */], __WEBPACK_IMPORTED_MODULE_5__expanded_tile_expanded_tile_component__["a" /* ExpandedTileComponent */], __WEBPACK_IMPORTED_MODULE_6__add_minutes_pipe__["a" /* AddMinutesPipe */], __WEBPACK_IMPORTED_MODULE_7__expanded_tile_order_order_component__["a" /* OrderComponent */]],
        providers: [__WEBPACK_IMPORTED_MODULE_4__wall_service__["a" /* WallService */], __WEBPACK_IMPORTED_MODULE_6__add_minutes_pipe__["a" /* AddMinutesPipe */]]
    })
], WallModule);

//# sourceMappingURL=wall.module.js.map

/***/ }),

/***/ "../../../../../src/app/wall/wall.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return WallService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_toPromise__ = __webpack_require__("../../../../rxjs/add/operator/toPromise.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_toPromise___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1_rxjs_add_operator_toPromise__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var WallService = (function () {
    function WallService(http) {
        this.http = http;
    }
    WallService.prototype.getLunches = function () {
        var _this = this;
        var host = false ? window.location.host : 'localhost:1337';
        return new Promise(function (resolve) {
            _this.http.get("http://" + host + "/api/lunch/list").toPromise().then(function (response) { return resolve(response.json()); });
        });
    };
    return WallService;
}());
WallService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_http__["a" /* Http */]) === "function" && _a || Object])
], WallService);

var _a;
//# sourceMappingURL=wall.service.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_23" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map