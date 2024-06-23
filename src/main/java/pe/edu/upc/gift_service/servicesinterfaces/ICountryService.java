package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.Country;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface ICountryService {
    public void insert(Country cntry);
    public void delete(int id);
    public Country listId(int id);
    public List<Country> list();
}
