import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, MaxLengthValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { AfiliadoDTO } from '../../dto/afiliado.dto';
import { GestionarAfiliadoService } from '../../services/gestionar.afiliado.service';

@Component({
  selector: 'app-gestionar-afiliado',
  templateUrl: './gestionar-afiliado.component.html',
  styleUrls: ['./gestionar-afiliado.component.css']
})
export class GestionarAfiliadoComponent implements OnInit {

   /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarAfiliadoForm : FormGroup;

    /**
     * Atributo que contendra la informacion del afiliado
     */
    public afiliadoDTO: AfiliadoDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaAfiliados : Array<AfiliadoDTO>;

    public idAfiliado : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    /**
     * atributo que representa la posicion del afiliado a editar
     */
    public posAfiliadoEditar:number=0;
    /**
     *Atributo que me permite saber si el dato es para actualizar o crear
     */
    public esEditar: boolean = false;

  constructor(private fb: FormBuilder,
              private router: Router,
              private gestionarAfiliadoService: GestionarAfiliadoService
              ) {
                this.crearControles();
               }

  ngOnInit() {
        this.afiliadoDTO = new AfiliadoDTO();
        this.listaAfiliados = new Array<AfiliadoDTO>();
        this.consultarAfiliados();
  }
    /**
     * metodo que permite crear los controles para el formulario
     */
    crearControles(): void {
      this.gestionarAfiliadoForm = this.fb.group({
          nombre : [null,Validators.required],
          correo: [null,Validators.email],
          pass : [null,Validators.compose([Validators.required, Validators.maxLength(10),
            Validators.minLength(3)])]
      });
  }

  /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarAfiliado(afiliadoParam: any): void {
      this.submitted = true;
      if (this.gestionarAfiliadoForm.invalid) {
          return;
      } else if (this.esEditar === true){
          this.afiliadoDTO =  this.listaAfiliados[this.posAfiliadoEditar];
          this.afiliadoDTO.nombre = afiliadoParam.nombre;
          this.afiliadoDTO.correo = afiliadoParam.correo;
          this.afiliadoDTO.pass = afiliadoParam.pass;
          this.modificarAfiliado(this.afiliadoDTO);
          
          this.esEditar = false;
      } else {
          this.afiliadoDTO = new AfiliadoDTO();
          this.afiliadoDTO.nombre = afiliadoParam.nombre;
          this.afiliadoDTO.correo = afiliadoParam.correo;
          this.afiliadoDTO.pass = afiliadoParam.pass;
  

          this.gestionarAfiliadoService.crearAfiliado(this.afiliadoDTO).subscribe(resultadoDTO => {
              if(resultadoDTO.exitoso) {
                  this.consultarAfiliados();
                  this.limpiarFormulario();
              }
              }, error => {
                  console.log(error);
                  });
              this.limpiarFormulario();
          }
  }
  /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarAfiliados(): void {
      this.gestionarAfiliadoService.consultarAfiliados().subscribe(listaAfiliados => {
          this.listaAfiliados = listaAfiliados;
      }, error => {
          console.log(error);
      });
  }

    /**
     * metodo que permite actualizar un dato en la bd
     */
    public modificarAfiliado(formData: any){
      this.gestionarAfiliadoService.modificarComic(formData).subscribe(resultadoDTO => {
          if(resultadoDTO.exitoso){
              this.consultarAfiliados();
              
          }else {
             alert(resultadoDTO.mensajeEjecucion) ;
          }
          this.limpiarFormulario();
      });
  }

      /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarAfiliado(posicion : number) : void {
      let afiliado = this.listaAfiliados[posicion];
      this.gestionarAfiliadoForm.controls.nombre.setValue(afiliado.nombre);
      this.gestionarAfiliadoForm.controls.pass.setValue(afiliado.pass);
      this.gestionarAfiliadoForm.controls.correotematica.setValue(afiliado.correo);
 
      
      this.desHabilitarCampos();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

      }
  /**
     * metodo que permite desHabilitar todos los campos del formularuiio
     */
    public desHabilitarCampos() {
      this.gestionarAfiliadoForm.controls.nombre.disable();
      this.gestionarAfiliadoForm.controls.pass.disable();
      this.gestionarAfiliadoForm.controls.correo.disable();

  }
  /**
     * metodo que permite editar o cerar un comic
     * @param comic 
     * @param pos 
     */
    public editarComic(comic: any, pos: number): void {
      this.posAfiliadoEditar=pos; 
      this.esEditar = true;
      this.gestionarAfiliadoForm.controls.nombre.setValue(comic.nombre);
      this.gestionarAfiliadoForm.controls.pass.setValue(comic.pass);
      this.gestionarAfiliadoForm.controls.correo.setValue(comic.correo);

  }
  /**
     * metodo que permite  reiniciar los valores por defecto del formulario
     */
    private limpiarFormulario(): void {
      this.submitted = false;
      this.gestionarAfiliadoForm.reset();
  }
}
