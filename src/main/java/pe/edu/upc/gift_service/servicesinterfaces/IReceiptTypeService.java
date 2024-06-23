package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.ReceiptType;

import java.util.List;

public interface IReceiptTypeService {
    public void insert(ReceiptType pt);

    public List<ReceiptType> list();

    public ReceiptType listId(int id);

    public void delete(int id);
}
