package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.PersonaDao;
import bo.edu.ucb.ingsoft.demorest.dto.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaBl {
    @Autowired
    PersonaDao personaDao;

    public Persona crearPersona(Persona persona) {
        // Computamos el nuemero de seguro social, conformado por los tres primeros caracteres
        // del nombre mas los tres primeros del apelliod
        persona.setNroSS( persona.getLast_name().substring(0,3).toUpperCase() + persona.getLast_name().substring(0,3));

        return personaDao.crearPersona(persona);
    }

    public Persona findPersonaById(Integer personaId) {

        return personaDao.findPersonaById(personaId);
    }

    public List<Persona> findAllPersonas() {
        return personaDao.findAllPersonas();
    }

}

