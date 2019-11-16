
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';
import { ResultadoDTO } from '../../dto/resultado.dto';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;
    /**
     * atributo que representa la posicion del comic a editar
     */
    public posComicEditar:number=0;
    /**
     *Atributo que me permite saber si el dato es para actualizar o crear
     */
    public esEditar: boolean = false;
    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb: FormBuilder,
        private router: Router, private gestionarComicService: GestionarComicService) {
            this.crearControles();
    }

     /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
      
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    
    }
    /**
     * metodo que permite crear los controles para el formulario
     */
    crearControles(): void {
        this.gestionarComicForm = this.fb.group({
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }
   /**
    * metodo que permite simular una lista con persistencia
    */
    // llenenarLista(): void {
    //     let comic1 : ComicDTO = new ComicDTO;
    //     comic1.id = '1';
    //     comic1.nombre = "prueba 1";
    //     comic1.editorial = "Marvel";
    //     comic1.tematica = "aventura";
    //     comic1.coleccion = "los maravillosos hermanos calvin";
    //     comic1.numeroPaginas = 33;
    //     comic1.precio = 455;
    //     comic1.autores = "los traviesos";
    //     comic1.color = true;
    //     this.listaComics.push(comic1);
    // }
    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic(comicDTO: any): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        } else if (this.esEditar === true){
            /* this.listaComics[this.posComicEditar].nombre = comicDTO.nombre;
            this.listaComics[this.posComicEditar].editorial = comicDTO.editorial;
            this.listaComics[this.posComicEditar].tematica = comicDTO.tematica;
            this.listaComics[this.posComicEditar].coleccion = comicDTO.coleccion;
            this.listaComics[this.posComicEditar].numeroPaginas = comicDTO.numeroPaginas;
            this.listaComics[this.posComicEditar].precio = comicDTO.precio;
            this.listaComics[this.posComicEditar].autores = comicDTO.autores;
            this.listaComics[this.posComicEditar].color = comicDTO.color; */
            var formData: any = new FormData();
            formData.append("idComic", this.gestionarComicForm.get('nombre').value);
            formData.append("nombre", this.gestionarComicForm.get('nombre').value);
            this.modificarComic(formData);
            
            this.esEditar = false;
        } else {
            this.comic = new ComicDTO();
            this.comic.nombre = comicDTO.nombre;
            this.comic.editorial = comicDTO.editorial;
            this.comic.tematica = comicDTO.tematica;
            this.comic.coleccion = comicDTO.coleccion;
            this.comic.numeroPaginas = comicDTO.numeroPaginas;
            this.comic.precio = comicDTO.precio;
            this.comic.autores = comicDTO.autores;
            this.comic.color = comicDTO.color;
            this.comic.cantidad = 12;
  
            this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
                if(resultadoDTO.exitoso) {
                    this.consultarComics();
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
    public consultarComics(): void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }
     /**
     * metodo que permite actualizar un dato en la bd
     */
    public modificarComic(formData: any){
        this.gestionarComicService.modificarComic(formData).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso){
                this.consultarComics();
                
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
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        
        this.desHabilitarCampos();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }
   
    /**
     * metodo que permite desHabilitar todos los campos del formularuiio
     */
    public desHabilitarCampos() {
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
    }
    /**
     * metodo que permite editar o cerar un comic
     * @param comic 
     * @param pos 
     */
    public editarComic(comic: any, pos: number): void {
        this.posComicEditar=pos; 
        this.esEditar = true;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
    }
    /**
     * metodo que permite  reiniciar los valores por defecto del formulario
     */
    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.reset();
    }
    /**
     * metodo que permite eliminar un elemento del formulario
     */
    private eliminarComic(posicionEliminar: number) {
        this.listaComics.splice(posicionEliminar, 1)
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() {
        return this.gestionarComicForm.controls;
    }
}