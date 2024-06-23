package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.ProductImageDetail;

import java.util.List;

@Repository
public interface IProductImageDetailRepository extends JpaRepository<ProductImageDetail, Integer> {
    @Query("from ProductImageDetail p WHERE p.products.idProduct =:id")
    public List<ProductImageDetail> allIamgeForProduct(int id);

}
