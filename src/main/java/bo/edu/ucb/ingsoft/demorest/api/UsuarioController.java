package bo.edu.ucb.ingsoft.demorest.api;

import bo.edu.ucb.ingsoft.demorest.bl.UsuarioBl;
import bo.edu.ucb.ingsoft.demorest.dto.ResponseDto;
import bo.edu.ucb.ingsoft.demorest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class UsuarioController {
    @Autowired
    public DataSource dataSource;
    @Autowired
    private UsuarioBl usuarioBl;

    @GetMapping(path = "/usuario/{id_owner}")
    public ResponseDto findUsuariosById(@PathVariable Integer id_owner) {
        Usuario usuario = usuarioBl.findUsuariosById(id_owner);
        if (usuario != null) {
            return new ResponseDto( true, usuario, null);
        } else {
            return new ResponseDto( false, null, "No existe el usuario con este codigo:");
        }
    }


    @GetMapping(path = "/usuario")
    public ResponseDto finAllUsuarios(){
        return new ResponseDto(true, usuarioBl.findAllUsuarios(), null);
    }


    @PostMapping(path = "/usuario")
    public ResponseDto createUsuario(@RequestBody Usuario usuario) {
        // Validar que los datos enviados son correctos.
        if (usuario.getFirst_name() == null || usuario.getFirst_name().trim().equals("")) {  // nombre: "     "
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe ser obligatorio" );
            return new ResponseDto( false, null, "El nombre debe ser obligatorio");
        }

        if (usuario.getLast_name() == null || usuario.getFirst_name().trim().equals("")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El apellido debe ser obligatorio" );
            return new ResponseDto( false, null, "El apellido debe ser obligatorio");
        }

        return new ResponseDto(true, usuarioBl.crearUsuario(usuario), null);
    }


}
