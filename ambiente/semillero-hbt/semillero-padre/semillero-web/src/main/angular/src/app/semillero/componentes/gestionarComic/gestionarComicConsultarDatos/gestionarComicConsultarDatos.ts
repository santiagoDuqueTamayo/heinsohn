import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
    selector : 'gCConsultarDatos',
    templateUrl : './gestionarComicConsultarDatos.html',
    styleUrls: ['./gestionarComicConsultarDatos.css']
})
/**
 * @description Componenete gCConsultar datos, el cual contiene la logica CRUD
 * 
 * @author Santiago Duque Tamayo <santiagohdt@gmail.com>
 */
export class GCConsultarDatosComponent implements OnInit{

    /**
    * atributo que define los contrles del formulario
     */
    public gcConsultarDatosForm: FormGroup;
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
     * metodo que inicializa los componentes de la clase
     */
    ngOnInit(): void {
    }
    /**
     * metodo que me permite asignar controles
     */
    asignarcontroles(): void{
        this.gcConsultarDatosForm = this.fBC.group({
            nombre : [this.activedRouting.snapshot.paramMap.get('nombre')],
            editorial : [this.activedRouting.snapshot.paramMap.get('editorial')],
            tematica : [this.activedRouting.snapshot.paramMap.get('tematica')],
            coleccion : [this.activedRouting.snapshot.paramMap.get('coleccion')],
            numeroPaginas : [this.activedRouting.snapshot.paramMap.get('numeroPaginas')],
            precio : [this.activedRouting.snapshot.paramMap.get('precio')],
            autores : [this.activedRouting.snapshot.paramMap.get('autores')],
            color : [this.activedRouting.snapshot.paramMap.get('color')]
        });
    }
    /**
     * metodo que permite deshabilitar los campos del formulario
     */
    desHabilitarCampos(): void{
        const consultarDatosF = this.gcConsultarDatosForm;
        consultarDatosF.controls.nombre.disable();
        consultarDatosF.controls.editorial.disable();
        consultarDatosF.controls.tematica.disable();
        consultarDatosF.controls.coleccion.disable();
        consultarDatosF.controls.numeroPaginas.disable();
        consultarDatosF.controls.precio.disable();
        consultarDatosF.controls.autores.disable();
        consultarDatosF.controls.color.disable();
    }
    regresar(): void {
        this.router.navigate(['gestionar-comic']);
    }
}
