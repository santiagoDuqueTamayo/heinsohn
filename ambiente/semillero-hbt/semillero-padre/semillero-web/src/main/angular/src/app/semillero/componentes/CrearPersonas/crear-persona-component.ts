import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


  @Component({
  selector: 'crear-persona',
  //templateUrl: './app.component.html',
  //styleUrls: ['./app.component.css']
})
export class CrearPersonaComponent implements OnInit{
  
  public listaApellidos : Array<any>= new Array<any>();
  public listaNombre=[];
  /**
   * para inicializar variables globales private para utilizarlo solo dentro de la clase, 
   * lo correcto es utilizarlo público
   */
  public nombreInstructorGlobal:string;
  ngOnInit(): void {
    /**
     * ASi utilizamos la declaracion de una varaibles local 
     */
    let nombreInstructor="Diego Alvarez";
    let nombreInstructorString: String ="Diego alvarez";

    this.nombreInstructorGlobal="Diego fernando alravrez"

    /**
     * Variable que recibe cualquier tipo de datos, incluso un objeto
     */
    let miVariable : any={
      id:1,
      nombre: "carlos",
      direccion:"carrera 4",
    };
    miVariable.genero="Masculino";
    /**
     * Agregando a la lista
     */
    this.listaApellidos.push(miVariable);
    /**
     * los dos puntos: son para recibir el tipo de datos asignaciones con =
     */
    miVariable.id=3;

  }
/**
 * public inicializarComponente() : Array<string> {
        let retorno : any;
        let objeto = undefined;
        if(objeto !== null){
            console.log("No es nulo")
        } else {
            console.log("Si es nulo");
        }
 
        console.log(1 == 1);
        console.log("1" == 1);
        console.log(1 === 1);
        console.log("1" === 1);
        return retorno;
    }
  public miMetodo(): void {
    
  }
 */
    
}

