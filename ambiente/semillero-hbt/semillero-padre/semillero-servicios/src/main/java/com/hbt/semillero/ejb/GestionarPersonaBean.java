/**
 * 
 */
package com.hbt.semillero.ejb;

import javax.persistence.EntityExistsException;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * clase bean que me permite gestionar una persona desde el ejb
 * @author admin
 *
 */
public class GestionarPersonaBean implements IGestionarPersonaBean{

	
	//esta clas eno la necesito de mmento porque persisto en cascada desde usuario
	//la cree por si decido hacer un cambio a futuro
	@Override
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) throws EntityExistsException, IllegalArgumentException {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


}
