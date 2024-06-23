package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Users;

public class EntrepreneurshipDTO {
    private Long id;
    private String nameEntrepreneurship;
    private String rucEntrepreneurship;
    private String locationEntrepreneurship;
    private String phoneEntrepreneurship;
    private Users users;

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
