package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query("from Product p WHERE p.category.nameCategory =:nombreC")
    public List<Product> productByNameCategory(@Param("nombreC") String nombreC);
    @Query("from Product p WHERE p.entrepreneurship.nameEntrepreneurship =:nombreE")
    public List<Product> productByNameEntrepreneurship(@Param("nombreE") String nombreE);
    @Query("from Product p WHERE p.nameProduct LIKE %:nombreP%")
    public List<Product> productByName(String nombreP);
    @Query(value = "SELECT p.id_product,p.description_product, p.name_product,\n" +
            "p.price_product, pi.image_route,ca.name_category\n" +
            "FROM product p inner join \n" +
            "product_image_detail pi on pi.product_id=p.id_product\n" +
            "inner join\n" +
            "categories ca on ca.id = p.category_id\n" +
            "where pi.num_product_image = 1",nativeQuery = true)
    public List<String[]> productForSale();

}
