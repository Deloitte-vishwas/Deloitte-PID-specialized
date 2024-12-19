import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HAFooterComponent } from './hafooter.component';

describe('HAFooterComponent', () => {
  let component: HAFooterComponent;
  let fixture: ComponentFixture<HAFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HAFooterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HAFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
