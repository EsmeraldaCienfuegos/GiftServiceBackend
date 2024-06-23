package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.Purchase;

import java.util.List;

@Repository
public interface IPurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "SELECT (select count(*) from purchase) as total_de_compras,'RECOJO' AS tipo_entrega, COUNT(id_purchase) AS cantidad_total_de_compras_de_usuarios FROM purchase \n" +
            "WHERE delivery_type_id = 1 \n" +
            "UNION\n" +
            "SELECT (select count(*) from purchase) as total_de_compras,'DELIVERY' AS tipo_entrega, COUNT(id_purchase) AS cantidad_total_de_compras_de_usuarios FROM purchase \n" +
            "WHERE delivery_type_id = 2; \n", nativeQuery = true)
    public List<String[]> QuantityByTypeDelivery ();

    @Query(value = "select pay_t.name_payment_type, count(*) as total from \n" +
            "entrepreneurships ent INNER JOIN \n" +
            "product pr ON ent.id = pr.entrepreneurship_id INNER JOIN \n" +
            "purchase_detail pu_d ON pr.id_product = pu_d.product_id INNER JOIN \n" +
            "purchase pu ON pu_d.purchase_id = pu.id_purchase INNER JOIN \n" +
            "payment_type pay_t ON pay_t.id_payment_type = pu.payment_type_id \n" +
            "WHERE pu.purchase_status = 'true' \n" +
            "GROUP BY pay_t.name_payment_type \n" +
            "ORDER BY pay_t.name_payment_type desc", nativeQuery = true)
    public List<String[]> RankingPaymentTypesUsed();

    @Query(value = "SELECT MAX(p.id_purchase) FROM  purchase p\n" +
            "WHERE p.users_id = 1",nativeQuery = true)
    public int maxIdPurchase(int idUsers);

}
