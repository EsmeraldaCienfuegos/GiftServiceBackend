package pe.edu.upc.gift_service.controllers;

public class LowScoreOneToThree {
    private int idProducto;
    private String NameProduct;
    private String descriptionProduct;
    private double LowScore;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public double getLowScore() {
        return LowScore;
    }

    public void setLowScore(double lowScore) {
        LowScore = lowScore;
    }
}
