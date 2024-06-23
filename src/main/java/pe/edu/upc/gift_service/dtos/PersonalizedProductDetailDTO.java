package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.PersonalizedDetail;
import pe.edu.upc.gift_service.entities.Product;

public class PersonalizedProductDetailDTO {
    private int idPersonalizedProductDetail;

    private PersonalizedDetail personalizedDetails;

    private Product products;

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
