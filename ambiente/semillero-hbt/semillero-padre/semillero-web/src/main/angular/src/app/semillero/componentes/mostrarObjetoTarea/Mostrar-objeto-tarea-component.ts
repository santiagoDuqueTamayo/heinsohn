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


    /**
     * atributo que define el nombre del elemento a ser eliminado
     */
    public nombreElementoEliminar:string;

    ngOnInit(): void {
      this.crearObjetos();
      this.convertirLista();
  

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

       let objeto2= this.revista= new Revista();
       objeto2.id=2;
       objeto2.nombre="superman";
       objeto2.editorial= "marvel";
       objeto2.tematica = "accion";
       objeto2.numeroPaginas = 75;
       objeto2.precio = 90,500.99;
       objeto2.autores = "santiago duque";
       objeto2.aColor = false;
       objeto2.fechaVenta= new Date("11-09-2019");
       objeto2.estado="activo";
    

       let objeto3= this.revista= new Revista();
       objeto3.id=3;
       objeto3.nombre="spiderman";
       objeto3.editorial= "dc";
       objeto3.tematica = "accion";
       objeto3.numeroPaginas = 40;
       objeto3.precio = 50,500.99;
       objeto3.autores = "Diego alvarez";
       objeto3.aColor = false;
       objeto3.fechaVenta= new Date("10-10-2019");
       objeto3.estado="activo";
   

       let objeto4= this.revista= new Revista();
       objeto4.id=4;
       objeto4.nombre="el inreible hulk";
       objeto4.editorial= "marvel";
       objeto4.tematica = "accion";
       objeto4.numeroPaginas = 95;
       objeto4.precio = 9,500.99;
       objeto4.autores = "Carlos villamizar";
       objeto4.aColor = false;
       objeto4.fechaVenta= new Date("05-06-2019");
       objeto4.estado="inactivo";
      

       let objeto5= this.revista= new Revista();
       objeto5.id=5;
       objeto5.nombre="tom y jerry";
       objeto5.editorial= "disney";
       objeto5.tematica = "comedia";
       objeto5.numeroPaginas = 14;
       objeto5.precio = 100,500.99;
       objeto5.autores = "Walt Disney";
       objeto5.aColor = false;
       objeto5.fechaVenta= new Date("01-10-2018");
       objeto5.estado="activo";
       
       this.listaObjetos.push(objeto1,objeto2,objeto3,objeto4,objeto5);
    

    }
    /**
     * metodo que convierte una lista de objetos a una lista de string
     */
    public convertirLista(): void {
    
      let listaconvertir=this.listaObjetos;
      for (let index = 0; index < listaconvertir.length; index++) {
       this.listaRevistas.push(JSON.stringify(listaconvertir[index]));
      }

 
    }
    public eliminarElemento(posicionAEliminar:number): string{
  
      if(this.listaObjetos.length>=posicionAEliminar){
          this.nombreElementoEliminar=this.listaObjetos[posicionAEliminar].nombre.concat("ha sido eliminado correctamente");
          this.listaObjetos.splice(posicionAEliminar,1);
          return this.nombreElementoEliminar;
        }
       
          return "en la posicion 3 no existe ningun elemento";
 
    }
  
  }