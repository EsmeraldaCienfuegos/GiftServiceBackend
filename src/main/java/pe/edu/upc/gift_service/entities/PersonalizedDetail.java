package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonalizedDetail")
public class PersonalizedDetail {
    //PersonalizedDetail
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonalizedDetail;
    @Column(name = "namePersonalizedDetail", nullable = false, length = 300)
    private String namePersonalizedDetail;
    @Column(name = "additionalPricePersonalizedDetail", nullable = false)
    private double additionalPricePersonalizedDetail;

    @Column(name = "imagePersonalizedDetail", nullable = false, length = 400)
    private String imagePersonalizedDetail;

    @ManyToOne
    @JoinColumn(name = "entrepreneurship_id")
    private Entrepreneurship entrepreneurships;

    public PersonalizedDetail() {
    }

    public PersonalizedDetail(int idPersonalizedDetail, String namePersonalizedDetail, double additionalPricePersonalizedDetail, String imagePersonalizedDetail, Entrepreneurship entrepreneurships) {
        this.idPersonalizedDetail = idPersonalizedDetail;
        this.namePersonalizedDetail = namePersonalizedDetail;
        this.additionalPricePersonalizedDetail = additionalPricePersonalizedDetail;
        this.imagePersonalizedDetail = imagePersonalizedDetail;
        this.entrepreneurships = entrepreneurships;
    }

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
