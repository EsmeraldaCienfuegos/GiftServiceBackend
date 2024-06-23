package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Country;
import pe.edu.upc.gift_service.entities.PersonalizedProductDetail;
import pe.edu.upc.gift_service.repositories.IPersonalizedProductDetailRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IPersonalizedProductDetailService;

import java.util.List;

@Service
public class PersonalizedProductDetailServiceImplement implements IPersonalizedProductDetailService {
    @Autowired
    private IPersonalizedProductDetailRepository ppdR;

    @Override
    public void insert(PersonalizedProductDetail ppd) {
        ppdR.save(ppd);
    }

    @Override
    public List<PersonalizedProductDetail> list() {
        return ppdR.findAll();
    }

    @Override
    public void delete(int id) {
        ppdR.deleteById(id);
    }

    @Override
    public PersonalizedProductDetail listId(int id) {
        return ppdR.findById(id).orElse(new PersonalizedProductDetail());
    }

    @Override
    public List<String[]> allDetailByProduct(int idProduct) {
        return ppdR.allDetailByProduct(idProduct);
    }
}
