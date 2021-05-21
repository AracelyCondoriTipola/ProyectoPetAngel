package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.PerfilDao;
import bo.edu.ucb.ingsoft.demorest.dto.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilBl {

    @Autowired
    PerfilDao perfilDao ;

    public Perfil findPerfilById(Integer id_owner) {
        return perfilDao.findPerfilById(id_owner);
    }
    public Perfil findPetById(Integer id_owner) {
        return perfilDao.findPetById(id_owner);
    }

    public Object crearPerfil(Perfil perfil) {
        perfil.setNroSS(perfil.getFirst_name().substring(0,3).toUpperCase()+ perfil.getLast_name().substring(0,3));
        return  perfilDao.crearPerfil(perfil);
    }
}
