package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.DeliveryType;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface IDeliveryTypeService {
    public void insert(DeliveryType pt);

    public List<DeliveryType> list();

    public DeliveryType listId(int id);

    public void delete(int id);
    public List<DeliveryType> findByNameDeliveryType(String nameDelivery);
    public void update (Integer id, DeliveryType deliveryType);

}
