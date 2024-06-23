package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Country;
import pe.edu.upc.gift_service.repositories.ICountryRepository;
import pe.edu.upc.gift_service.servicesinterfaces.ICountryService;
import java.util.List;

@Service
public class CountryServiceImplement implements ICountryService {
    @Autowired
    private ICountryRepository cntrY;
    @Override
    public void insert(Country cntry) { cntrY.save(cntry);}

    @Override
    public void delete(int id) { cntrY.deleteById(id);}

    @Override
    public Country listId(int id) {
        return cntrY.findById(id).orElse(new Country());
    }

    @Override
    public List<Country> list() {
        return cntrY.findAll();
    }
}
