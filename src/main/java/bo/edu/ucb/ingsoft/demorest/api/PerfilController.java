package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.PerfilBl;
import bo.edu.ucb.ingsoft.demorest.dto.Perfil;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
@Service
public class PerfilController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private PerfilBl perfilBl;


    @GetMapping(path = "/usuario/perfil/{id_owner}")
    public ResponseDto findPerfilById(@PathVariable Integer id_owner) {
        Perfil perfil = perfilBl.findPerfilById(id_owner);
        if (perfil != null) {
            return new ResponseDto( true, perfil, null);
        } else {
            return new ResponseDto( false, null, "No existe el usuario con este codigo:");
        }
    }


     @GetMapping(path = "/usuario/pet/{id_owner}")
    public ResponseDto findPetById(@PathVariable Integer id_owner) {
        Perfil perfil = perfilBl.findPetById(id_owner);
        if (perfil != null) {
            return new ResponseDto( true, perfil, null);
        } else {
            return new ResponseDto( false, null, "No existe el usuario con este codigo:");
        }
    }
    @PostMapping(path = "/usuario/perfil")
    public ResponseDto crearPerfil(@RequestBody Perfil perfil) {
        // Validar que los datos enviados son correctos.
        if (perfil.getFirst_name() == null || perfil.getFirst_name().trim().equals("")) {  // nombre: "     "
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
            return new ResponseDto( false, null, "El nombre debe ser obligatorio");
        }

        if (perfil.getLast_name() == null || perfil.getFirst_name().trim().equals("")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido debe ser obligatorio" );
            return new ResponseDto( false, null, "El apellido debe ser obligatorio");
        }

        return new ResponseDto(true, perfilBl.crearPerfil(perfil), null);
    }



}
