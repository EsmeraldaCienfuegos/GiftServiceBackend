package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Country;
import pe.edu.upc.gift_service.entities.ProductImageDetail;
import pe.edu.upc.gift_service.repositories.IProductImageDetailRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IProductImageDetailService;

import java.util.List;

@Service
public class ProductImageDetailServiceImplement implements IProductImageDetailService {
    @Autowired
    private IProductImageDetailRepository pidR;

    @Override
    public void insert(ProductImageDetail pid) {
        pidR.save(pid);
    }

    @Override
    public List<ProductImageDetail> list() {
        return pidR.findAll();
    }

    @Override
    public void delete(int id) {
        pidR.deleteById(id);
    }

    @Override
    public ProductImageDetail listId(int id) {
        return pidR.findById(id).orElse(new ProductImageDetail());
    }
    @Override
    public List<ProductImageDetail> allIamgeForProduct(int id) {
        return pidR.allIamgeForProduct(id);
    }
}
