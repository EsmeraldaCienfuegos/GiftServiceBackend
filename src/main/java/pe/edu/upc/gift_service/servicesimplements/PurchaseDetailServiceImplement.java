package pe.edu.upc.gift_service.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.gift_service.entities.PurchaseDetail;
import pe.edu.upc.gift_service.repositories.IPurchaseDetailRepository;
import pe.edu.upc.gift_service.servicesinterfaces.IPurchaseDetailService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseDetailServiceImplement implements IPurchaseDetailService {
    @Autowired
    private IPurchaseDetailRepository pdR;


    @Override
    public void insert(PurchaseDetail purchaseDetail) {
        pdR.save(purchaseDetail);
    }

    @Override
    public List<PurchaseDetail> list() {
        return pdR.findAll();
    }

    @Override
    public PurchaseDetail listId(int id) {
        return pdR.findById(id).orElse(new PurchaseDetail());
    }

    @Override
    public void delete(int id) {
        pdR.deleteById(id);
    }

    @Override
    public List<String[]> quantityPurchaseByEntrepreneurship() {
        return pdR.quantityPurchaseByEntrepreneurship();
    }

    @Override
    public List<String[]> TotalAmountByEntrepreneurship() {
        return pdR.TotalAmountByEntrepreneurship();
    }

    @Override
    public int sumTotalProductsByPurchaseDate(LocalDate fechaCompra) {
        return pdR.sumTotalProductsByPurchaseDate(fechaCompra);
    }

    @Override
    public List<String[]> filterBestSellerProductDescent() {
        return pdR.filterBestSellerProductDescent();
    }


    @Override
    public List<String[]> RankingCategoryPurchase() {
        return pdR.RankingCategoryPurchase();
    }

}
