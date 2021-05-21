package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.PetDao;
import bo.edu.ucb.ingsoft.demorest.dto.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PetBl {
    @Autowired
    PetDao petDao;

    public Pet crearPets(Pet pet){
       return  petDao.crearPets(pet);
    }

    public Pet findPetsById(Integer id_pet) {
        return petDao.findPetsById(id_pet);
    }

    public List<Pet> findAllPets() {
        return petDao.findAllPets();
    }

}
