package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "entrepreneurships")
public class Entrepreneurship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameEntrepreneurship", nullable = false)
    private String nameEntrepreneurship;
    @Column(name = "rucEntrepreneurship", nullable = false)
    private String rucEntrepreneurship;
    @Column(name = "locationEntrepreneurship", nullable = false)
    private String locationEntrepreneurship;
    @Column(name = "phoneEntrepreneurship", nullable = false)
    private String phoneEntrepreneurship;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;

    public Entrepreneurship() {
    }
    public Entrepreneurship(Long id, String nameEntrepreneurship, String rucEntrepreneurship, String locationEntrepreneurship, String phoneEntrepreneurship, Users users) {
        this.id = id;
        this.nameEntrepreneurship = nameEntrepreneurship;
        this.rucEntrepreneurship = rucEntrepreneurship;
        this.locationEntrepreneurship = locationEntrepreneurship;
        this.phoneEntrepreneurship = phoneEntrepreneurship;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEntrepreneurship() {
        return nameEntrepreneurship;
    }

    public void setNameEntrepreneurship(String nameEntrepreneurship) {
        this.nameEntrepreneurship = nameEntrepreneurship;
    }

    public String getRucEntrepreneurship() {
        return rucEntrepreneurship;
    }

    public void setRucEntrepreneurship(String rucEntrepreneurship) {
        this.rucEntrepreneurship = rucEntrepreneurship;
    }

    public String getLocationEntrepreneurship() {
        return locationEntrepreneurship;
    }

    public void setLocationEntrepreneurship(String locationEntrepreneurship) {
        this.locationEntrepreneurship = locationEntrepreneurship;
    }

    public String getPhoneEntrepreneurship() {
        return phoneEntrepreneurship;
    }

    public void setPhoneEntrepreneurship(String phoneEntrepreneurship) {
        this.phoneEntrepreneurship = phoneEntrepreneurship;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
