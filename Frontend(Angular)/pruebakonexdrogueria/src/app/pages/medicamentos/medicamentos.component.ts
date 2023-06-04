import { Component, OnInit, OnDestroy } from '@angular/core';
import { MedicamentoService } from 'src/app/services/medicamento.service';
import { MenuItem, MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { VentaService } from 'src/app/services/venta.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Table } from 'primeng/table';
import { MedicamentoAgregarComponent } from '../medicamento-agregar/medicamento-agregar.component';
import { VentaMedicamentoComponent } from '../venta-medicamento/venta-medicamento.component';
import { Location } from '@angular/common';
import { Medicamento } from 'src/app/model/medicamento';

@Component({
  selector: 'app-medicamentos',
  templateUrl: './medicamentos.component.html',
  styleUrls: ['./medicamentos.component.css'],
  providers: [DialogService, MessageService],
})
export class MedicamentosComponent implements OnInit, OnDestroy {
  constructor(
    private medicantoService: MedicamentoService,
    private ventaService: VentaService,
    public dialogService: DialogService,
    public messageService: MessageService,
    private location: Location
  ) {}

  ngOnInit() {
    this.getMedicamentos();
  }

  ref: DynamicDialogRef = new DynamicDialogRef();
  nombre: String = '';
  laboratorio: String = '';
  date: Date = new Date();
  medicacion :Medicamento[]= [];
  items: MenuItem[] = [
    {
      label: 'Update',
      icon: 'pi pi-refresh',
      command: () => {
        this.showUpdateMedication();
      },
    },
    { separator: true },
    {
      label: 'Delete(Change Estado)',
      icon: 'pi pi-times',
      command: () => {
        this.delet();
      },
      expanded: true,
    },
  ];

  cols: any[] = [
    { field: 'estado', header: 'Estado' },
    { field: 'nombre', header: 'Nombre' },
    { field: 'laboratorio', header: 'Laboratorio' },
    { field: 'fechaFabricacion', header: 'Fecha Fabricacion' },
    { field: 'fechaVencimiento', header: 'Fecha Vencimiento' },
    { field: 'cantidadStock', header: 'Stock' },
    { field: 'valorUnitario', header: 'Valor Unitario' },
    { field: 'acciones', header: 'Valor Unitario' },
  ];

  statuses = [
    { label: 'Unqualified', value: 'unqualified' },
    { label: 'Qualified', value: 'qualified' },
    { label: 'New', value: 'new' },
    { label: 'Negotiation', value: 'negotiation' },
    { label: 'Renewal', value: 'renewal' },
    { label: 'Proposal', value: 'proposal' }
];

  async getMedicamentos() {
    await this.medicantoService
      .getMedicamentos()
      .toPromise()
      .then((data) => (
        this.medicacion = data));

        this.medicacion.forEach(element => {
console.log(element)
        });
     
     
  }

  handleClick(nombre: String, laboratorio: String) {
    this.nombre = nombre;
    this.laboratorio = laboratorio;
  }

  async delet() {
    await this.medicantoService
      .delete(this.nombre, this.laboratorio)
      .toPromise()
      .then((data) => {
        console.log(data);
      });

      //window.location.reload()
  }

  async sell(medicamento:any) {

    const ref: DynamicDialogRef = this.dialogService.open(
      VentaMedicamentoComponent,
      {
        header: 'Confirmar cantidad',
        width: '70%',
        data: {
          m: medicamento,
        },
        contentStyle: { overflow: 'auto' },
        baseZIndex: 10000,
        maximizable: true,
      }
    );
  }

  clear(table: Table) {
    table.clear();
  }

  ngOnDestroy() {
    if (this.ref) {
      this.ref.close();
    }
  }


  showCreateMedication() {
    let medicamento = {
      nombre: '',
      laboratorio: '',
      fechaFabricacion: new Date(),
      fechaVencimiento: new Date(),
      cantidadStock: 0,
      valorUnitario: 0,
    };

    const ref: DynamicDialogRef = this.dialogService.open(
      MedicamentoAgregarComponent,
      {
        header: 'Registrar Medicamento',
        width: '70%',
        data: {
          texto_header: 'Registrar Medicamento',
          m: medicamento,
        },
        contentStyle: { overflow: 'auto' },
        baseZIndex: 10000,
        maximizable: true,
      }
    );
  }

  async showUpdateMedication() {
    await this.medicantoService
      .getMedicamento(this.nombre, this.laboratorio)
      .toPromise()
      .then((data) => {
        this.showUpdateDialogMedicamento(data);
      });
  }

  showUpdateDialogMedicamento(medicamento: any) {
    const ref: DynamicDialogRef = this.dialogService.open(
      MedicamentoAgregarComponent,
      {
        header: 'Modificar Medicamento',
        width: '70%',
        data: {
          texto_header: 'Modificar Medicamento',
          m: medicamento,
        },
        contentStyle: { overflow: 'auto' },
        baseZIndex: 10000,
        maximizable: true,
      }
    );
  }


  fecha: Date=new Date();

  filterX(event: any,fecha:String ){
    console.log(event);

    console.log(fecha);
    
    
  }

  transformDate(fecha:any):String{

    return new Date(fecha).toString()
  }
}
