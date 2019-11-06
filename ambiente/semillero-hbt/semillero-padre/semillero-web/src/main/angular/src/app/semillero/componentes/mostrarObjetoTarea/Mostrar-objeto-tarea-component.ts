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
       this.listaObjetos.push(objeto1);

       let objeto2= this.revista= new Revista();
       objeto1.id=2;
       objeto1.nombre="superman";
       objeto1.editorial= "marvel";
       objeto1.tematica = "accion";
       objeto1.numeroPaginas = 75;
       objeto1.precio = 90,500.99;
       objeto1.autores = "santiago duque";
       objeto1.aColor = false;
       objeto1.fechaVenta= new Date("11-09-2019");
       objeto1.estado="activo";
       this.listaObjetos.push(objeto2);

       let objeto3= this.revista= new Revista();
       objeto1.id=3;
       objeto1.nombre="spiderman";
       objeto1.editorial= "dc";
       objeto1.tematica = "accion";
       objeto1.numeroPaginas = 40;
       objeto1.precio = 50,500.99;
       objeto1.autores = "Diego alvarez";
       objeto1.aColor = false;
       objeto1.fechaVenta= new Date("10-10-2019");
       objeto1.estado="activo";
       this.listaObjetos.push(objeto3);

       let objeto4= this.revista= new Revista();
       objeto1.id=4;
       objeto1.nombre="el inreible hulk";
       objeto1.editorial= "marvel";
       objeto1.tematica = "accion";
       objeto1.numeroPaginas = 95;
       objeto1.precio = 9,500.99;
       objeto1.autores = "Carlos villamizar";
       objeto1.aColor = false;
       objeto1.fechaVenta= new Date("05-06-2019");
       objeto1.estado="inactivo";
       this.listaObjetos.push(objeto4);

       let objeto5= this.revista= new Revista();
       objeto1.id=5;
       objeto1.nombre="tom y jerry";
       objeto1.editorial= "disney";
       objeto1.tematica = "comedia";
       objeto1.numeroPaginas = 14;
       objeto1.precio = 100,500.99;
       objeto1.autores = "Walt Disney";
       objeto1.aColor = false;
       objeto1.fechaVenta= new Date("01-10-2018");
       objeto1.estado="activo";
       this.listaObjetos.push(objeto5);
    

    }
    /**
     * metodo que convierte una lista de objetos a una lista de string
     */
    public convertirLista(): void {
    
    
      for (let index = 0; index < this.listaObjetos.length; index++) {

        this.listaRevistas.push(JSON.stringify(this.listaObjetos[index]));
      }

 
    }

  
  }