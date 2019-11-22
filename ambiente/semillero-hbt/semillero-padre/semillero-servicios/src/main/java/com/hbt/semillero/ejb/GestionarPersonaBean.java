/**
 * GestionarPersonaBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Persona;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Stateless
public class GestionarPersonaBean implements IGestionarPersonaLocal{
	
	@PersistenceContext
    private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#crearPersona(com.hbt.semillero.dto.PersonaDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = convertirPersonaDTOToPersona(personaDTO);
        em.persist(persona);		
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#consultarPersona(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public PersonaDTO consultarPersona(String id) {
		Persona persona = em.find(Persona.class, Long.parseLong(id));
		PersonaDTO personaDTO = convertirPersonaToPersonaDTO(persona);
		return personaDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarPersonaLocal#consultarpersonas()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<PersonaDTO> consultarPersonas() {
		List<PersonaDTO> resultadosPersonaDTO = new ArrayList<PersonaDTO>();
		List<Persona> resultados = em.createQuery("select c from Persona c").getResultList();
		for (Persona persona : resultados) {
			resultadosPersonaDTO.add(convertirPersonaToPersonaDTO(persona));
		}
		return resultadosPersonaDTO;
	}
	
	
	
	private Persona convertirPersonaDTOToPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
        if(personaDTO.getId()!=null) {
            persona.setId(Long.parseLong(personaDTO.getId()));
        }
        persona.setNombre(personaDTO.getNombre());
        persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
        return persona;
	}
	
	private PersonaDTO convertirPersonaToPersonaDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        if(persona.getId()!=null) {
         personaDTO.setId(persona.getId().toString());
        }
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
        return personaDTO;
    }

}
