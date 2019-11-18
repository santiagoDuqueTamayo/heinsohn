import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { UsuarioDTO } from '../dto/Usuario.dto';


/**
 * @description Servicio encargado de llamar a los servicios REST de gestionar Usuario
 * @author Santiago Duque<santiagohdt@gmail.com>
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarUsuarioService{

  /**
   * Constructor de la clase
   */
  constructor(injector: Injector, private httpClient : HttpClient) {
    
  }
  
  /**
   * @description Metodo encargado de invocar el servicio REST consultar Usuarios
   * @author Santiago Duque<santiagohdt@gmail.com>
   */
  public consultarUsuarios(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/consultarUsuarios');
  }

  /**
   * @description Metodo encargado de invocar el servicio REST crear Usuario
   * @author Santiago Duque<santiagohdt@gmail.com>
   * @param UsuarioDTO contiene la informacion del Usuario a persistir
   */
  public crearUsuario(UsuarioDTO : UsuarioDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/crear',UsuarioDTO);
  }

   /**
   * @description Metodo encargado de invocar el servicio REST crear Usuario
   * @author Santiago Duque<santiagohdt@gmail.com>
   * @param UsuarioDTO contiene la informacion del Usuario a persistir
   */
  public modificarUsuario(formData: any): Observable<any> {
  
      let idUsuario:number;
      let nombre: string;
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarUsuario/modificar',idUsuario=formData.get('idUsuario'),nombre=formData.get('nombre'));
  }
}
