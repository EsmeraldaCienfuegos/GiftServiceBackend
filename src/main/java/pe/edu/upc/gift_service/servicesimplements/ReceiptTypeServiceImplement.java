package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.ReceiptType;
import pe.edu.upc.gift_service.repositories.IReceiptTypeRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IReceiptTypeService;

import java.util.List;

@Service
public class ReceiptTypeServiceImplement implements IReceiptTypeService {
    @Autowired
    private IReceiptTypeRepository rtR;
    @Override
    public void insert(ReceiptType pt) {
        rtR.save(pt);
    }

    @Override
    public List<ReceiptType> list() {
        return rtR.findAll();
    }

    @Override
    public ReceiptType listId(int id) {
        return rtR.findById(id).orElse(new ReceiptType());
    }

    @Override
    public void delete(int id) {
        rtR.deleteById(id);
    }

}
