package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Product;

public class ProductImageDetailDTO {
    private int idProductImageDetail;
    private String imageRoute;
    private Product products;
    private  int numProductImage;

    public int getNumProductImage() {
        return numProductImage;
    }

    public void setNumProductImage(int numProductImage) {
        this.numProductImage = numProductImage;
    }

    public int getIdProductImageDetail() {
        return idProductImageDetail;
    }

    public void setIdProductImageDetail(int idProductImageDetail) {
        this.idProductImageDetail = idProductImageDetail;
    }

    public String getImageRoute() {
        return imageRoute;
    }

    public void setImageRoute(String imageRoute) {
        this.imageRoute = imageRoute;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
