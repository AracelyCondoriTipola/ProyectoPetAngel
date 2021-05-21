package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.UsuarioDao;
import bo.edu.ucb.ingsoft.demorest.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioBl {
    @Autowired
    UsuarioDao usuarioDao;

    public Usuario crearUsuario(Usuario usuario){
        usuario.setNroSS(usuario.getFirst_name().substring(0,3).toUpperCase()+ usuario.getLast_name().substring(0,3));
        return  usuarioDao.crearUsuario(usuario);
    }

    public Usuario findUsuariosById(Integer id_owner) {
        return usuarioDao.findUsuariosById(id_owner);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioDao.findAllUsuarios();
    }



}
