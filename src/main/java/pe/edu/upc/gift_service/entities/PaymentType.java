package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PaymentType")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPayment_Type;

    @Column(name = "namePayment_Type", nullable = false, length = 50)
    private String namePayment_Type;


    public PaymentType() {
    }

    public PaymentType(int idPayment_Type, String namePayment_Type) {
        this.idPayment_Type = idPayment_Type;
        this.namePayment_Type = namePayment_Type;
    }

    public int getIdPayment_Type() {
        return idPayment_Type;
    }

    public void setIdPayment_Type(int idPayment_Type) {
        this.idPayment_Type = idPayment_Type;
    }

    public String getNamePayment_Type() {
        return namePayment_Type;
    }

    public void setNamePayment_Type(String namePayment_Type) {
        this.namePayment_Type = namePayment_Type;
    }
}
