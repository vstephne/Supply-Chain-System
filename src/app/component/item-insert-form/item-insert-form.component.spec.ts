import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemInsertFormComponent } from './item-insert-form.component';

describe('ItemInsertFormComponent', () => {
  let component: ItemInsertFormComponent;
  let fixture: ComponentFixture<ItemInsertFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemInsertFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemInsertFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
