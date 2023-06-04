import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MedicamentosComponent } from './pages/medicamentos/medicamentos.component';
import { MedicamentoAgregarComponent } from './pages/medicamento-agregar/medicamento-agregar.component';
import { VentasComponent } from './pages/ventas/ventas.component';

export const routes: Routes = [  
  {
  path: 'medicamentos',
  component: MedicamentosComponent,
},
{
  path: 'medicamentos_agregar',
  component: MedicamentoAgregarComponent,
},

{
  path: 'ventas',
  component: VentasComponent,
},

{ path: '**', pathMatch: 'full', redirectTo: 'medicamentos' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
