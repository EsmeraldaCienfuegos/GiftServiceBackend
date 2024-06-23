package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Entrepreneurship;

public class PersonalizedDetailDTO {
    private int idPersonalizedDetail;
    private String namePersonalizedDetail;
    private double additionalPricePersonalizedDetail;

    private String imagePersonalizedDetail;

    private Entrepreneurship entrepreneurships;

    public int getIdPersonalizedDetail() {
        return idPersonalizedDetail;
    }

    public void setIdPersonalizedDetail(int idPersonalizedDetail) {
        this.idPersonalizedDetail = idPersonalizedDetail;
    }

    public String getNamePersonalizedDetail() {
        return namePersonalizedDetail;
    }

    public void setNamePersonalizedDetail(String namePersonalizedDetail) {
        this.namePersonalizedDetail = namePersonalizedDetail;
    }

    public double getAdditionalPricePersonalizedDetail() {
        return additionalPricePersonalizedDetail;
    }

    public void setAdditionalPricePersonalizedDetail(double additionalPricePersonalizedDetail) {
        this.additionalPricePersonalizedDetail = additionalPricePersonalizedDetail;
    }

    public String getImagePersonalizedDetail() {
        return imagePersonalizedDetail;
    }

    public void setImagePersonalizedDetail(String imagePersonalizedDetail) {
        this.imagePersonalizedDetail = imagePersonalizedDetail;
    }

    public Entrepreneurship getEntrepreneurships() {
        return entrepreneurships;
    }

    public void setEntrepreneurships(Entrepreneurship entrepreneurships) {
        this.entrepreneurships = entrepreneurships;
    }
}
