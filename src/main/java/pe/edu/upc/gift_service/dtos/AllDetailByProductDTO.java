package pe.edu.upc.gift_service.dtos;

public class AllDetailByProductDTO {
    private int idPersonalizedDetail;
    private double additionalPricePersonalizedDetail;
    private String imagePersonalizedDetail;
    private String namePersonalizedDetail;

    public int getIdPersonalizedDetail() {
        return idPersonalizedDetail;
    }

    public void setIdPersonalizedDetail(int idPersonalizedDetail) {
        this.idPersonalizedDetail = idPersonalizedDetail;
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

    public String getNamePersonalizedDetail() {
        return namePersonalizedDetail;
    }

    public void setNamePersonalizedDetail(String namePersonalizedDetail) {
        this.namePersonalizedDetail = namePersonalizedDetail;
    }
}
