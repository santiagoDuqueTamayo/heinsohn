import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-consultar-datos-usuario',
  templateUrl: './consultar-datos-usuario.component.html',
  styleUrls: ['./consultar-datos-usuario.component.css']
})
export class ConsultarDatosUsuarioComponent implements OnInit {

   /**
    * atributo que define los contrles del formulario
     */
    public gConsultarDatosForm: FormGroup;
    /**
     * 
     * @param router metodo que define el constructor de la clase
     * @param fBC 
     */
    constructor(private router: Router,
         private fBC: FormBuilder , private activedRouting: ActivatedRoute){
            this.asignarcontroles();
            this.desHabilitarCampos();
    }

     /**
     * metodo que me permite asignar controles
     */
    asignarcontroles(): void{
      this.gConsultarDatosForm = this.fBC.group({
          nombre : [this.activedRouting.snapshot.paramMap.get('nombre')],
          editorial : [this.activedRouting.snapshot.paramMap.get('cedula')],
          tematica : [this.activedRouting.snapshot.paramMap.get('estado')],
          coleccion : [this.activedRouting.snapshot.paramMap.get('cfecha_creacion')],
      });
  }
  /**
   * metodo que permite deshabilitar los campos del formulario
   */
  desHabilitarCampos(): void{
      const consultarDatosF = this.gConsultarDatosForm;
      consultarDatosF.controls.nombre.disable();
      consultarDatosF.controls.cedula.disable();
      consultarDatosF.controls.estado.disable();
      consultarDatosF.controls.fecha_creacion.disable();

  }
  regresar(): void {
      this.router.navigate(['gestionar-usuario']);
  }
  ngOnInit() {
  }

}
