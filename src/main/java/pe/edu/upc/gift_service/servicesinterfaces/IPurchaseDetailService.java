package pe.edu.upc.gift_service.servicesinterfaces;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.PurchaseDetail;

import java.time.LocalDate;
import java.util.List;

public interface IPurchaseDetailService {
    public void insert(PurchaseDetail purchaseDetail);
    public List<PurchaseDetail> list();

    public PurchaseDetail listId(int id);
    public void delete(int id);
    public List<String[]> quantityPurchaseByEntrepreneurship();
    public List<String[]> TotalAmountByEntrepreneurship();
    public int sumTotalProductsByPurchaseDate(LocalDate fechaCompra);
    public List<String[]> filterBestSellerProductDescent();
    public List<String[]> RankingCategoryPurchase();
}
