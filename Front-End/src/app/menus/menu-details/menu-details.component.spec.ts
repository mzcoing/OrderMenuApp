import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuDetailsComponent } from './menu-details.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AppModule } from 'src/app/app.module';

describe('MenuDetailsComponent', () => {
  let component: MenuDetailsComponent;
  let fixture: ComponentFixture<MenuDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuDetailsComponent ], imports: [AppRoutingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
