import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MedicamentosComponent } from './pages/medicamentos/medicamentos.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule } from '@angular/forms';
import { MedicamentoService } from './services/medicamento.service';
import { MedicamentoAgregarComponent } from './pages/medicamento-agregar/medicamento-agregar.component';
import { CommonModule } from '@angular/common';
import { SplitButtonModule } from 'primeng/splitbutton';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { DialogModule } from 'primeng/dialog';
import { MessageService } from 'primeng/api';
import { CardModule } from 'primeng/card';
import { CalendarModule } from 'primeng/calendar';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { TabMenuModule } from 'primeng/tabmenu';
import { TableModule } from 'primeng/table';
import { InputNumberModule } from 'primeng/inputnumber';
import { VentasComponent } from './pages/ventas/ventas.component';
import { VentaMedicamentoComponent } from './pages/venta-medicamento/venta-medicamento.component';
import { ToastModule } from 'primeng/toast';
@NgModule({
  declarations: [
    AppComponent,
    MedicamentosComponent,
    NavbarComponent,
    MedicamentoAgregarComponent,
    VentasComponent,
    VentaMedicamentoComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,

    SplitButtonModule,
    HttpClientModule,

    DynamicDialogModule,
    DialogModule,
    ButtonModule,
    TabMenuModule,
    TableModule,
    CardModule,
    CalendarModule,
    InputTextModule,
    InputNumberModule,
    ToastModule,
    CommonModule,
  ],
  providers: [MedicamentoService,MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
