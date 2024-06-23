package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedProductDetail;
import pe.edu.upc.gift_service.entities.ProductImageDetail;

import java.util.List;

public interface IProductImageDetailService {
    public void insert(ProductImageDetail pid);

    public List<ProductImageDetail> list();

    public void delete(int id);

    public ProductImageDetail listId(int id);
    public List<ProductImageDetail> allIamgeForProduct(int id);
}
