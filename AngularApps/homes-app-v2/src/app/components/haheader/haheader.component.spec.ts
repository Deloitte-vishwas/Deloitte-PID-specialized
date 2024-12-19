import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HAHeaderComponent } from './haheader.component';

describe('HAHeaderComponent', () => {
  let component: HAHeaderComponent;
  let fixture: ComponentFixture<HAHeaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HAHeaderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HAHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
