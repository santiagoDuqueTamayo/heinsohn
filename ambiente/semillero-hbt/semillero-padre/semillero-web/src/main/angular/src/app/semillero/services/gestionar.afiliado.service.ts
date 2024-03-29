import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { AfiliadoDTO } from '../dto/afiliado.dto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar comic
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarAfiliadoService {

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar comics
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   */
  public consultarAfiliados(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/gestionarAfiliado/consultarAfiliados');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public crearAfiliado(afiliadoDTO : AfiliadoDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/gestionarAfiliado/crear',afiliadoDTO);
  }

   /**
   * @description Metodo encargado de invocar el servicio REST crear comic
   * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
   * @param comicDTO contiene la informacion del comic a persistir
   */
  public modificarComic(formData: any): Observable<any> {
  
      let idComic:number;
      let nombre: string;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar',idComic=formData.get('idComic'),nombre=formData.get('nombre'));
  }
}
