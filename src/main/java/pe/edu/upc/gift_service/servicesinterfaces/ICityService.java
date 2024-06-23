package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.City;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface ICityService {
    public void insert(City cty);
    public void delete(int id);
    public City listId(int id);
    public List<City> list();
}
