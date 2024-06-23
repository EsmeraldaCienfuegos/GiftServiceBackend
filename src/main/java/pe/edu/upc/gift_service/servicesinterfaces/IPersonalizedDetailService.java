package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface IPersonalizedDetailService {
    public void insert(PersonalizedDetail pd);

    public List<PersonalizedDetail> list();

    public void delete(int id);
    public PersonalizedDetail listId(int id);

}
