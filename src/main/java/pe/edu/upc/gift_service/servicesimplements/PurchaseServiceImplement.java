package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.Purchase;
import pe.edu.upc.gift_service.repositories.IPurchaseRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IPurchaseService;

import java.util.List;

@Service
class PurchaseServiceImplement implements IPurchaseService {
    @Autowired
    private IPurchaseRepository iP;

    @Override
    public void insert(Purchase pt) {
        iP.save(pt);
    }

    @Override
    public Purchase insertR(Purchase pt) {
        return iP.save(pt);
    }

    @Override
    public List<Purchase> list() {
        return iP.findAll();
    }

    @Override
    public Purchase listId(int id) {
        return iP.findById(id).orElse(new Purchase());
    }

    @Override
    public void delete(int id) {
        iP.deleteById(id);
    }
    @Override
    public void update(Purchase purchase) {
        iP.save(purchase);
    }

    @Override
    public List<String[]> QuantityByTypeDelivery() {
        return iP.QuantityByTypeDelivery();
    }

    @Override
    public List<String[]> RankingPaymentTypesUsed( ) {
        return iP.RankingPaymentTypesUsed( );
    }
    @Override
    public int maxIdPurchase(int idUsers) {
        return iP.maxIdPurchase(idUsers);
    }
}
