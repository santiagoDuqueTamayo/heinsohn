import { PersonaDTO } from './persona.dto';

/**
 * @description Clase UsuarioTO que contiene la informacion de un usuario
 * 
 * @author Santiago Duque <santiagohdt@gmail.com>
 */
export class UsuarioDTO{
    /**
   * Indicador de resultado.
   */
  public id: string;

  /**
  * Indicador de resultado.
  */
  public nombre_auto_generado: string;


  /**
  * Indicador de resultado.
  */
  public fecha_creacion: Date;

  /**
   * indicador de resltado
   */
  public estado: boolean;

  /**
   * indica la persona contenida en el usuario
   */
  public personaDTO: PersonaDTO= new PersonaDTO();

}