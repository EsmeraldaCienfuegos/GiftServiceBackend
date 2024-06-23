package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.PaymentType;
import pe.edu.upc.gift_service.repositories.IPaymentTypeRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IPaymentTypeService;

import java.util.List;

@Service
public class PaymentTypeServiceImplement implements IPaymentTypeService {
    @Autowired
    private IPaymentTypeRepository ptR;

    @Override
    public void insert(PaymentType pt) {
        ptR.save(pt);
    }

    @Override
    public List<PaymentType> list() {
        return ptR.findAll();
    }

    @Override
    public PaymentType listId(int id) {
        return ptR.findById(id).orElse(new PaymentType());
    }

    @Override
    public void delete(int id) { ptR.deleteById(id);
    }
}
