package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Role;
import pe.edu.upc.gift_service.repositories.IRoleRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IRoleService;
import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService{
    @Autowired
    private IRoleRepository rleR;
    @Override
    public void insert(Role rle) { rleR.save(rle);}
    @Override
    public List<Role> list() {return rleR.findAll();}

    @Override
    public void delete(int id) {
        rleR.deleteById(id);
    }

    @Override
    public Role listId(Integer idRol) {
        return rleR.findById(idRol).orElse(new Role());
    }

}

