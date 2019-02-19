import { TestBed } from '@angular/core/testing';

import { MenuService } from './menu.service';
import { HttpClientModule } from '@angular/common/http';

describe('MenuService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: MenuService = TestBed.get(MenuService);
    expect(service).toBeTruthy();
  });
});
