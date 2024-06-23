package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DeliveryType")
public class DeliveryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDeliveryType;
    @Column(name = "nameDeliveryType", nullable = false, length = 50)
    private String nameDeliveryType;


    public DeliveryType() {
    }

    public DeliveryType(int idDeliveryType, String nameDeliveryType) {
        this.idDeliveryType = idDeliveryType;
        this.nameDeliveryType = nameDeliveryType;
    }

    public int getIdDeliveryType() {
        return idDeliveryType;
    }

    public void setIdDeliveryType(int idDeliveryType) {
        this.idDeliveryType = idDeliveryType;
    }

    public String getNameDeliveryType() {
        return nameDeliveryType;
    }

    public void setNameDeliveryType(String nameDeliveryType) {
        this.nameDeliveryType = nameDeliveryType;
    }
}
