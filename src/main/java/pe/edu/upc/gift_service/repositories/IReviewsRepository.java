package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.Product;
import pe.edu.upc.gift_service.entities.Reviews;

import java.util.List;

@Repository
public interface IReviewsRepository extends JpaRepository<Reviews,Integer> {

    @Query(value = "SELECT SUM(r.score_reviews)AS totalScore FROM public.reviews r INNER JOIN public.product p ON r.product_id = p.id_product \n" +
            "WHERE  r.product_id= ?1 AND p.entrepreneurship_id = ?2",nativeQuery = true)
    public int TotalScoreByProduct(int product_id, int entrepreneurship_id);

    @Query(value = "SELECT \tp.id_product as idProducto, p.name_product as nombre_producto, \n" +
            "\t\tp.description_product as descripcion_del_productos,   \n" +
            "\t\tr.score_reviews as calificacion \n" +
            "FROM reviews r  \n" +
            "inner join \n" +
            "product p \n" +
            "on \n" +
            "p.id_product=r.product_id \n" +
            "WHERE score_reviews IN (1,2,3) \n", nativeQuery = true)
    public List<String[]> LowScoreProduct();

    @Query("from Reviews r WHERE r.product.idProduct =:id")
    public List<Reviews> reviewsByProductId(int id);
}
