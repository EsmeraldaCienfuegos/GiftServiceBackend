package pe.edu.upc.gift_service.dtos;

public class QuantityByTypeDeliveryDTO {
    public int getTotalpurchase() {
        return totalpurchase;
    }

    public void setTotalpurchase(int totalpurchase) {
        this.totalpurchase = totalpurchase;
    }

    private int totalpurchase;
    private String nameTypeDelivery;
    private int quantityTypeDelivery;

    public String getNameTypeDelivery() {
        return nameTypeDelivery;
    }

    public void setNameTypeDelivery(String nameTypeDelivery) {
        this.nameTypeDelivery = nameTypeDelivery;
    }

    public int getQuantityTypeDelivery() {
        return quantityTypeDelivery;
    }

    public void setQuantityTypeDelivery(int quantityTypeDelivery) {
        this.quantityTypeDelivery = quantityTypeDelivery;
    }
}
