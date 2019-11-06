import { Component, OnInit } from '@angular/core';
import {Revista} from '../../ejercicioDeObjetos/Revista';


/**
 * Etiqueta que indica que mostrarObjetoTarea es un componente
 */
@Component({
    selector: 'crear-objeto',
    templateUrl: './Mostrar-objeto-tarea.html',
  })
/**
 * @description Componente MostrarObjetoTarea que contiene la lógica del Comic
 * 
 * @author Santiago Duque Tamayo <santiagohdt@gmail.com>
 */
  export class MostrarObjetoTarea implements OnInit{
    /**
     * atributo que indica una definicion de la clase Comic
     */
    public revista: Revista;

      /**
     * Arreglo de tipo comic donde seran almacenadas las instancias
     */
    public listaObjetos: Array<Revista>= new Array<Revista>();
    /**
     * Arreglo de String con los datos de las revistas a  imprimir
     */
    public listaRevistas: Array<string>= new Array<string>();

    ngOnInit(): void {
      this.crearObjetos();
     this.listaRevistas=this.convertirLista();

    }
    /**
     * metodo que crea los objetos y los agrega a una lista
     */
    public crearObjetos() : void{
        
       let objeto1= this.revista= new Revista();
       objeto1.id=1;
       objeto1.nombre="batman";
       objeto1.editorial= "marvel";
       objeto1.tematica = "accion";
       objeto1.numeroPaginas = 50;
       objeto1.precio = 60,500.99;
       objeto1.autores = "Pedrito barrera";
       objeto1.aColor = true;
       objeto1.fechaVenta= new Date("10-10-2019");
       objeto1.estado="activo";
       this.listaObjetos.push(objeto1);
       console.log(this.listaObjetos[0]);

    }
    /**
     * metodo que convierte una lista de objetos a una lista de string
     */
    public convertirLista(): Array<string> {
      let listaelementos=this.listaObjetos;
      let element: Array<string>=new Array<string>();
      let cadena: string;
      for (let index = 0; index < listaelementos.length; index++) {
        cadena=JSON.stringify(listaelementos[index]);
        element.push(cadena);
      }

      return element;
    }

  
  }