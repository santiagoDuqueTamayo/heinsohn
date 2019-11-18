import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ComicDTO } from '../dto/Comic.dto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar Comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService{

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar Comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear Comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param ComicDTO contiene la informacion del Comic a persistir
   */
  public crearComic(ComicDTO : ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear',ComicDTO);
  }

   /**
   * @description Metodo encargado de invocar el servicio REST crear Comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param ComicDTO contiene la informacion del Comic a persistir
   */
  public modificarComic(formData: any): Observable<any> {
  
      let idComic:number;
      let nombre: string;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',idComic=formData.get('idComic'),nombre=formData.get('nombre'));
  }
}
