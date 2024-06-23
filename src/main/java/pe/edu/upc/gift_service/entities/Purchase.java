package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPurchase;
    @Column(name = "pricePurchase", nullable = false)
    private float pricePurchase;
    @Column(name = "datePurchase", nullable = false)
    private LocalDate datePurchase;
    @Column(name = "purchaseStatus", nullable = false)
    private boolean purchaseStatus;
    @Column(name = "address", nullable = false,length = 40)
    private String address;
    @ManyToOne
    @JoinColumn(name = "Delivery_Type_id")
    private DeliveryType deliveryTypes;
    @ManyToOne
    @JoinColumn(name = "Payment_Type_id")
    private PaymentType paymentTypes;
    @ManyToOne
    @JoinColumn(name = "Receipt_Type_id")
    private ReceiptType receiptTypes;
    @ManyToOne
    @JoinColumn(name = "Users_id")
    private Users users;


    public Purchase() {
    }

    public Purchase(int idPurchase, float pricePurchase, LocalDate datePurchase, boolean purchaseStatus, String address, DeliveryType deliveryTypes, PaymentType paymentTypes, ReceiptType receiptTypes, Users users) {
        this.idPurchase = idPurchase;
        this.pricePurchase = pricePurchase;
        this.datePurchase = datePurchase;
        this.purchaseStatus = purchaseStatus;
        this.address = address;
        this.deliveryTypes = deliveryTypes;
        this.paymentTypes = paymentTypes;
        this.receiptTypes = receiptTypes;
        this.users = users;
    }

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
