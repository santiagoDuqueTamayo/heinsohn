/**
 * @description Clase Comic que contiene la informacion de un comic
 * 
 * @author Santiago Duque Tamayo <santiagohdt@gmail.com>
 */

 export class Revista {

    /**
     * Expresa el identificador del comic
     */
    public id: number;
    /**
     * Expresa el nombre de un comic
     */
    public nombre: string;
    /**
     * Expresa el nombre d ela editorial que publica el comic
     */
    public editorial:string;
    /**
     * Expresa la tematica que tiene el comic
     */
    public tematica: string;
    /**
     * indica el numero de paginas que tiene un comic
     */
    public numeroPaginas: number;
     /**
     * indica el numero de paginas que tiene un comic
     */
    public precio: number;
    /**
     * indica el autor que escribio el comic
     */
    public autores: string;
    /**
     * indica si es a color o a blanco y negro a color true o false de lo contrario
     */
    public aColor: boolean;
    /**
     * indica la fehca en la que se vendio el comic
     */
    public fechaVenta: Date;
    /**
     * indica si un comic esta disponible o fue vendido
     */
    public estado: string;
 }