package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.Purchase;

import java.util.List;

public interface IPurchaseService {
    public void insert(Purchase pt);
    public Purchase insertR(Purchase pt);
    public List<Purchase> list();

    public Purchase listId(int id);
    public void delete(int id);
    public void update(Purchase purchase);


    public List<String[]> QuantityByTypeDelivery ();

    public List<String[]> RankingPaymentTypesUsed();
    public int maxIdPurchase(int idUsers);
}
