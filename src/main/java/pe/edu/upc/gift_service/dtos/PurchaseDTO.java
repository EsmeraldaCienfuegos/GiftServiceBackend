package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.DeliveryType;
import pe.edu.upc.gift_service.entities.PaymentType;
import pe.edu.upc.gift_service.entities.ReceiptType;
import pe.edu.upc.gift_service.entities.Users;

import java.time.LocalDate;

public class PurchaseDTO {
    private int idPurchase;
    private float pricePurchase;
    private LocalDate datePurchase;
    private boolean purchaseStatus;
    private String address;
    private DeliveryType deliveryTypes;
    private PaymentType paymentTypes;
    private ReceiptType receiptTypes;

    private Users users;

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public float getPricePurchase() {
        return pricePurchase;
    }

    public void setPricePurchase(float pricePurchase) {
        this.pricePurchase = pricePurchase;
    }

    public LocalDate getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDate datePurchase) {
        this.datePurchase = datePurchase;
    }

    public boolean isPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(boolean purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DeliveryType getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(DeliveryType deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public PaymentType getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(PaymentType paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public ReceiptType getReceiptTypes() {
        return receiptTypes;
    }

    public void setReceiptTypes(ReceiptType receiptTypes) {
        this.receiptTypes = receiptTypes;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
