package pe.edu.upc.gift_service.dtos;


import pe.edu.upc.gift_service.entities.Product;
import pe.edu.upc.gift_service.entities.Purchase;

public class PurchaseDetailDTO {
    private int idPurchaseDetail;
    private Double amountTotalPurchaseDetail;
    private int cantidadPurchaseDetail;
    private Purchase purchase;
    private Product product;

    public int getIdPurchaseDetail() {
        return idPurchaseDetail;
    }

    public void setIdPurchaseDetail(int idPurchaseDetail) {
        this.idPurchaseDetail = idPurchaseDetail;
    }

    public Double getAmountTotalPurchaseDetail() {
        return amountTotalPurchaseDetail;
    }

    public void setAmountTotalPurchaseDetail(Double amountTotalPurchaseDetail) {
        this.amountTotalPurchaseDetail = amountTotalPurchaseDetail;
    }

    public int getCantidadPurchaseDetail() {
        return cantidadPurchaseDetail;
    }

    public void setCantidadPurchaseDetail(int cantidadPurchaseDetail) {
        this.cantidadPurchaseDetail = cantidadPurchaseDetail;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
