/**
 * 
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import com.hbt.semillero.dto.AfiliadoDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Afiliado;
import com.hbt.semillero.entidades.Comic;

/**
 * @author admin
 *
 */
@Stateless
public class GestionarAfiliadoBean implements IGestionarAfiliadoBean{
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearAfiliado(com.hbt.semillero.dto.AfiliadoDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearAfiliado(AfiliadoDTO afiliadoDTO) {
		// TODO Auto-generated method stub
		Afiliado afiliado;
		ResultadoDTO resultadoDTO= new ResultadoDTO();
		try {
			afiliado=(convertirAfiliadoDTOToAfiliado(afiliadoDTO));
			em.persist(afiliado);
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("se ha creado la persona correctamente");
			return resultadoDTO;
		} catch (EntityExistsException e) {
			// TODO: handle exception
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("error al intentar crear la persona"+e);
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("error al intentar crear la persona"+e);
		}finally {
			return resultadoDTO;
		}
			
		
		
	}
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarAfiliadoLocal#modificarAfiliado(com.hbt.semillero.dto.AfiliadoDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarAfiliado(Long id, String nombre, AfiliadoDTO afiliadoDTO){
		// TODO Auto-generated method stub
		ResultadoDTO resultadoDTO= new ResultadoDTO();
		Afiliado afiliadoModificar;
		try {
			if (afiliadoDTO==null) {
				//ComicDTO comicDTO= new ComicDTO("6", nombre, editorial, tematica, coleccion, numeroPaginas, precio, color, autores, fechaVenta, estado, cantidad)
//				manejar la entidad , si esta manejada el entity manager puede manejarla
				afiliadoModificar=em.find(Afiliado.class, id);
			} else {
				afiliadoModificar=convertirAfiliadoDTOToAfiliado(afiliadoDTO);
			}//TODO validar si comicModificar llego con datos
			afiliadoModificar.setNombre(nombre);
			// si encuentra en la bd actualiza, sino inserta
			em.merge(afiliadoModificar);
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("error al intentar modificar el afiliado"+e);
			
		}
		return resultadoDTO;
		
	}
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarAfiliadoLocal#crearAfiliado(com.hbt.semillero.dto.AfiliadoDTO)
	 */
	@Override
	public void eliminarAfiliado(Long idAfiliado) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarAfiliadoLocal#crearAfiliado(com.hbt.semillero.dto.AfiliadoDTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public AfiliadoDTO consultarAfiliado(Long idAfiliado) {
		// TODO Auto-generated method stub
		AfiliadoDTO afiliadoDTO;
		try {
			if (idAfiliado!=null) {
				afiliadoDTO=convertirAfiliadoToAfiliadoDTO(em.find(Afiliado.class, idAfiliado));
				if (afiliadoDTO==null) {
					return null;
				}else {
					return afiliadoDTO;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarAfiliadoLocal#consultarAfiliado(com.hbt.semillero.dto.AfiliadoTO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<AfiliadoDTO> consultarAfiliados() {
		List<AfiliadoDTO> resultadosAfiliadoDTO=new ArrayList<AfiliadoDTO>();
		List<Afiliado> resultados= em.createQuery("select a from Afiliado a").getResultList();
		
		for ( Afiliado afiliado: resultados) {
			resultadosAfiliadoDTO.add(convertirAfiliadoToAfiliadoDTO(afiliado));
		}
		return resultadosAfiliadoDTO;
	}
	/**
	 * metodo qu permite convertir un  afiliado en un afiliadoDTO
	 * @param afiliado
	 * @return
	 */
	private AfiliadoDTO convertirAfiliadoToAfiliadoDTO(Afiliado afiliado) {
		AfiliadoDTO afiliadoDTO= new AfiliadoDTO();
		try {
			if (afiliado.getId()!=null) {
				afiliadoDTO.setId(afiliado.getId());
				afiliadoDTO.setNombre(afiliado.getNombre());
				afiliadoDTO.setPass(afiliado.getPass());
				afiliadoDTO.setCorreo(afiliado.getCorreo());
				
			} else {
				return null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return afiliadoDTO;
	}
	
	private Afiliado convertirAfiliadoDTOToAfiliado(AfiliadoDTO afiliadoDTO) {
		Afiliado afiliado = new Afiliado();
		try {
			if (afiliadoDTO.getId()!=null) {
				afiliado.setId(afiliadoDTO.getId());
			
			}
			afiliado.setNombre(afiliadoDTO.getNombre());
			afiliado.setPass(afiliadoDTO.getPass());
			afiliado.setCorreo(afiliadoDTO.getCorreo());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} 
		return afiliado;
		
	}

}
