package pe.edu.upc.gift_service.dtos;

public class QuantityReviewDTO {
    private String nameProduct;
    private int quantityReview;

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantityReview() {
        return quantityReview;
    }

    public void setQuantityReview(int quantityReview) {
        this.quantityReview = quantityReview;
    }
}
