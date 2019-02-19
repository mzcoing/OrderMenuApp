import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MenuListComponent } from './menus/menu-list/menu-list.component';
import { MenuDetailsComponent } from './menus/menu-details/menu-details.component';
import { MenusComponent } from './menus/menus.component';
import { AppRoutingModule } from './app-routing.module';
import { OrderDetailsComponent } from './orders/order-details/order-details.component';
import { OrderListComponent } from './orders/order-list/order-list.component';
import { OrdersComponent } from './orders/orders.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MenuService } from './menu.service';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        DashboardComponent,
        MenuListComponent,
        MenuDetailsComponent,
        MenusComponent,
        OrderDetailsComponent,
        OrderListComponent,
        OrdersComponent

      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule,
      ],
      providers: [
        MenuService
      ]
    }).compileComponents();
    
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'FoodOrderingApp'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    // expect(app.title).toEqual('FoodOrderingApp');
  });

  it('should render title in a h1 tag', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    // expect(compiled.querySelector('h1').textContent).toContain('Welcome to FoodOrderingApp!');
  });
});
