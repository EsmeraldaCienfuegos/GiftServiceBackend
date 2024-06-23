package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    @Column(name = "nameProduct", nullable = false)
    private String nameProduct;
    @Column(name = "priceProduct", nullable = false)
    private double priceProduct;
    @Column(name = "descriptionProduct", nullable = false)
    private String descriptionProduct;
    @Column(name = "stockProduct", nullable = false)
    private int stockProduct;

    @ManyToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Entrepreneurship_id")
    private Entrepreneurship entrepreneurship;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double priceProduct, String descriptionProduct, int stockProduct, Category category, Entrepreneurship entrepreneurship) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.stockProduct = stockProduct;
        this.category = category;
        this.entrepreneurship = entrepreneurship;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Entrepreneurship getEntrepreneurship() {
        return entrepreneurship;
    }

    public void setEntrepreneurship(Entrepreneurship entrepreneurship) {
        this.entrepreneurship = entrepreneurship;
    }
}
