package pe.edu.upc.gift_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.gift_service.entities.DeliveryType;

import java.util.List;

@Repository
public interface IDeliveryTypeRepository extends JpaRepository<DeliveryType, Integer> {
    public List<DeliveryType> findByNameDeliveryType(String nameDelivery);
}
