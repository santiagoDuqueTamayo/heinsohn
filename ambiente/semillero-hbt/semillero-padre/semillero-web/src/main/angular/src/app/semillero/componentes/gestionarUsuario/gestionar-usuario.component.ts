import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UsuarioDTO } from 'src/app/semillero/dto/usuario.dto';
import { Router } from '@angular/router';
import { GestionarUsuarioService } from '../../services/gestionar.usuario.service';



@Component({
  selector: 'app-gestionar-usuario',
  templateUrl: './gestionar-usuario.component.html',
  styleUrls: ['./gestionar-usuario.component.css']
})
export class GestionarUsuarioComponent implements OnInit {

   /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarUsuarioForm : FormGroup;
  
    /**
     * Atributo que contendra la informacion del Usuario
     */
    public usuarioDTO: UsuarioDTO;

    /**
     * Atributo que contendra la lista de Usuarios creados
     */
    public listaUsuarios : Array<UsuarioDTO>;

    public idUsuario : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    /**
     * atributo que representa la posicion del Usuario a editar
     */
    public posUsuarioEditar:number=0;
    /**
     *Atributo que me permite saber si el dato es para actualizar o crear
     */
    public esEditar: boolean = false;

    /**
      * atributo para manejar las fechas
    */
   public fechaActual:Date;
  constructor(  private fb: FormBuilder,
                private router: Router,
                private gestionarUsuarioService: GestionarUsuarioService) { 

                   this.crearControles();
                   this.fechaActual=new Date;
                   this.fechaActual.toString
                }
               


          ngOnInit() {
            this.usuarioDTO = new UsuarioDTO();
            this.listaUsuarios = new Array<UsuarioDTO>();
            this.consultarUsuarios();
      }

       /**
         * metodo que permite crear los controles para el formulario
        */
        crearControles(): void {
          this.gestionarUsuarioForm = this.fb.group({
              nombre : [null,Validators.required],
              cedula: [null,Validators.required],
              fecha_creacion: [null,Validators.required]
          });
      }

      /**
     * @description Metodo que permite validar el formulario y crear o actulizar un usuario
     */
    public crearActualizarUsuario(usuarioParam: any): void {
      this.submitted = true;
      if (this.gestionarUsuarioForm.invalid) {
          return;
      } else if (this.esEditar === true){
          this.usuarioDTO =  this.listaUsuarios[this.posUsuarioEditar];
          this.usuarioDTO.nombre_auto_generado = usuarioParam.nombre;
          this.usuarioDTO.id = usuarioParam.id;
     
          this.modificarUsuario(this.usuarioDTO);
          
          this.esEditar = false;
      } else {
          this.usuarioDTO = new UsuarioDTO();
          this.usuarioDTO.personaDTO.nombre = usuarioParam.nombre;
          this.usuarioDTO.personaDTO.cedula = usuarioParam.cedula;
          this.usuarioDTO.fecha_creacion = usuarioParam.fecha_creacion;
          this.usuarioDTO.estado = usuarioParam.estado;

          this.gestionarUsuarioService.crearUsuario(this.usuarioDTO).subscribe(resultadoDTO => {
            alert(JSON.stringify(resultadoDTO));
            if(resultadoDTO.exitoso) {
                  this.consultarUsuarios();
                  this.limpiarFormulario();
              }
              }, error => {
                  console.log(error);
                  });
              this.limpiarFormulario();
          }
        }

        /**
         * @description Metodo encargado de consultar los usuarios existentes
         * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
        */
          public consultarUsuarios(): void {
              this.gestionarUsuarioService.consultarUsuarios().subscribe(listaUsuarios => {
                  this.listaUsuarios = listaUsuarios;
                  alert(JSON.stringify(listaUsuarios));
              }, error => {
                  console.log(error);
              });
            }

            /**
              * @description metodo que permite actualizar un dato en la bd
              */
            public modificarUsuario(usuarioDTO: any){
                this.gestionarUsuarioService.modificarUsuario(usuarioDTO).subscribe(resultadoDTO => {
                    if(resultadoDTO.exitoso){
                        this.consultarUsuarios();
                        
                    }else {
                      alert(resultadoDTO.mensajeEjecucion) ;
                    }
                    this.limpiarFormulario();
                });
          }

           /**
     * Metodo que permite consultar un usuariode la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del Usuario seleccionado
     */
          public consultarUsuario(posicion : number) : void {
                    let usuarios = this.listaUsuarios[posicion];
                    this.f.nombre.setValue(usuarios.nombre);
                    this.f.cedula.setValue(usuarios.cedula);
                    this.f.fecha_creacion.setValue(usuarios.fecha_creacion);
              
                    
                    this.desHabilitarCampos();
      //        this.f.color.enable(); para habilitar el campo

            }

            /**
     * metodo que permite desHabilitar todos los campos del formularuiio
     */
    public desHabilitarCampos() {
      this.f.nombre.disable();
      this.f.cedula.disable();
      this.f.fecha_creacion.disable();

    }

     /**
     * metodo que permite editar o cerar un usuario
     * @param comic 
     * @param pos 
     */
    public editarComic(comic: any, pos: number): void {
      this.posUsuarioEditar=pos; 
      this.esEditar = true;
      this.f.nombre.setValue(comic.nombre);
      this.f.cedula.setValue(comic.cedula);
      this.f.fecha_creacion.setValue(comic.fecha_creacion);

  }
    /**
     * metodo que permite  reiniciar los valores por defecto del formulario
     */
    private limpiarFormulario(): void {
      this.submitted = false;
      this.gestionarUsuarioForm.reset();
  }
  
    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
      return this.f;
  }
}
