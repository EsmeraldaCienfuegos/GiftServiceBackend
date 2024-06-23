package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Country;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.repositories.IPersonalizedDetailRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IPersonalizedDetailService;

import java.util.List;

@Service
public class PersonalizedDetailServiceImplement implements IPersonalizedDetailService {
    @Autowired
    private IPersonalizedDetailRepository iR;
    @Override
    public void insert(PersonalizedDetail pd) {
        iR.save(pd);
    }

    @Override
    public List<PersonalizedDetail> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public PersonalizedDetail listId(int id) {
        return iR.findById(id).orElse(new PersonalizedDetail());
    }
}
