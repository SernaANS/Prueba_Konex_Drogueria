import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicamentoAgregarComponent } from './medicamento-agregar.component';

describe('MedicamentoAgregarComponent', () => {
  let component: MedicamentoAgregarComponent;
  let fixture: ComponentFixture<MedicamentoAgregarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MedicamentoAgregarComponent]
    });
    fixture = TestBed.createComponent(MedicamentoAgregarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
