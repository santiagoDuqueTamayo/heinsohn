import { Component } from "@angular/core";

/**
 * @description Componente datos, contiene la logica que representa los datos del usuario 
 * desarrollados
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */

@Component({
    selector: 'usuario',
    templateUrl:'./datos-component.html',
})

export class DatosComponent{
     /**
     * Atributo que contendra el nombre del aprendiz
     */
    nombre="Santiago Duque Tamayo";
    /**
     * Atributo que contendra la ciudad del aprendiz
     */
    ciudad="Armenia-Quindío";
    /**
     * Atributo que contendra una concatenacion del nombre con la ciudad
     */
    concatenacionNomCiu=this.nombre.concat(", ").concat(this.ciudad);

}

