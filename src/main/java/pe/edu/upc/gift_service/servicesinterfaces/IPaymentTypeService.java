package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PaymentType;
import pe.edu.upc.gift_service.entities.PersonalizedDetail;

import java.util.List;

public interface IPaymentTypeService {
    public void insert(PaymentType pt);

    public List<PaymentType> list();

    public PaymentType listId(int id);

    public void delete(int id);

}
