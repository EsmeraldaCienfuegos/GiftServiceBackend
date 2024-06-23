package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ReceiptType")
public class ReceiptType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceipt_Type;

    @Column(name = "nameReceipt_Type", nullable = false, length = 50)
    private String nameReceipt_Type;


    public ReceiptType() {
    }

    public ReceiptType(int idReceipt_Type, String nameReceipt_Type) {
        this.idReceipt_Type = idReceipt_Type;
        this.nameReceipt_Type = nameReceipt_Type;
    }

    public int getIdReceipt_Type() {
        return idReceipt_Type;
    }

    public void setIdReceipt_Type(int idReceipt_Type) {
        this.idReceipt_Type = idReceipt_Type;
    }

    public String getNameReceipt_Type() {
        return nameReceipt_Type;
    }

    public void setNameReceipt_Type(String nameReceipt_Type) {
        this.nameReceipt_Type = nameReceipt_Type;
    }
}
