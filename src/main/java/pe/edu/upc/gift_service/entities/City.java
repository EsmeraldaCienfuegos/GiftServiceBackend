package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCity;
    @Column(name = "nameCity", nullable = false, length = 50)
    private String nameCity;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country counTry;

    public City() {
    }

    public City(int idCity, String nameCity, Country counTry) {
        this.idCity = idCity;
        this.nameCity = nameCity;
        this.counTry = counTry;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public Country getCounTry() {
        return counTry;
    }

    public void setCounTry(Country counTry) {
        this.counTry = counTry;
    }
}
