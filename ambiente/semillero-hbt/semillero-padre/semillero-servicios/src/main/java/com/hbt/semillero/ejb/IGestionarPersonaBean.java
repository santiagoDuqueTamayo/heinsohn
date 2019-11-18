/**
 * 
 */
package com.hbt.semillero.ejb;

import javax.ejb.Local;
import javax.persistence.EntityExistsException;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * interface que me permite definir los metodos para una gestionar una persona
 * @author admin
 *
 */
@Local
public interface IGestionarPersonaBean {

	//esta clas eno la necesito de mmento porque persisto en cascada desde usuario
	//la cree por si decido hacer un cambio a futuro
	/**
	 * metodo que me indica como crear una persona y persistirla
	 */
	public ResultadoDTO crearPersona(PersonaDTO personaDTO)throws EntityExistsException, IllegalArgumentException;
}
