package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Role;

import java.util.List;

public interface IRoleService {

    public void insert(Role rle);
    public List<Role> list();
    public void delete(int id);
    public Role listId(Integer idRol);
}
