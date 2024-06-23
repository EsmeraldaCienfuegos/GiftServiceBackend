package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.PersonalizedProductDetail;

import java.util.List;
@Repository
public interface IPersonalizedProductDetailRepository extends JpaRepository<PersonalizedProductDetail, Integer> {
    @Query(value = "SELECT pd.id_personalized_detail,pd.additional_price_personalized_detail,pd.image_personalized_detail, \n" +
            "pd.name_personalized_detail \n " +
            "FROM public.personalized_product_detail ppd INNER JOIN \n" +
            "public.personalized_detail pd ON ppd.personalized_detail_id = pd.id_personalized_detail \n" +
            "where ppd.product_id = ?1",nativeQuery = true)
    public List<String[]> allDetailByProduct(int idProduct);
}
