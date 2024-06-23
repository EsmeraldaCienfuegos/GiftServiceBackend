package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonalizedProductDetail")
public class PersonalizedProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonalizedProductDetail;

    @ManyToOne
    @JoinColumn(name = "personalizedDetail_id")
    private PersonalizedDetail personalizedDetails;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    public PersonalizedProductDetail() {
    }

    public PersonalizedProductDetail(int idPersonalizedProductDetail, PersonalizedDetail personalizedDetails, Product products) {
        this.idPersonalizedProductDetail = idPersonalizedProductDetail;
        this.personalizedDetails = personalizedDetails;
        this.products = products;
    }

    public int getIdPersonalizedProductDetail() {
        return idPersonalizedProductDetail;
    }

    public void setIdPersonalizedProductDetail(int idPersonalizedProductDetail) {
        this.idPersonalizedProductDetail = idPersonalizedProductDetail;
    }

    public PersonalizedDetail getPersonalizedDetails() {
        return personalizedDetails;
    }

    public void setPersonalizedDetails(PersonalizedDetail personalizedDetails) {
        this.personalizedDetails = personalizedDetails;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
