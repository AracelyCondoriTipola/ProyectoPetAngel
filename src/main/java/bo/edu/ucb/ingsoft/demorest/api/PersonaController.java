package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.PersonaBl;
import bo.edu.ucb.ingsoft.demorest.dto.Persona;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class PersonaController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private PersonaBl personaBl;

    @GetMapping(path = "/persona/{personaId}")
    public ResponseDto findPersonaById(@PathVariable Integer personaId) {
        Persona persona = personaBl.findPersonaById(personaId);
        if (persona != null) {
            return new ResponseDto( true, persona, null);
        } else {
            return new ResponseDto( false, null, "No existe la persona con codigo:");
        }
    }

    @GetMapping(path = "/persona")
    public ResponseDto findAllPersonas() {
        return new ResponseDto( true, personaBl.findAllPersonas(), null);
    }

    @PostMapping(path = "/persona")
    public ResponseDto createPersona(@RequestBody Persona persona) {
        // Validar que los datos enviados son correctos.
        if (persona.getFirst_name() == null || persona.getFirst_name().trim().equals("")) {  // nombre: "     "
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
            return new ResponseDto( false, null, "El nombre debe ser obligatorio");
        }

        if (persona.getLast_name() == null || persona.getFirst_name().trim().equals("")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido debe ser obligatorio" );
            return new ResponseDto( false, null, "El apellido debe ser obligatorio");
        }

        return new ResponseDto(true, personaBl.crearPersona(persona), null);
    }

}