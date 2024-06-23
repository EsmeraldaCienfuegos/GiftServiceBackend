package pe.edu.upc.gift_service.dtos;

public class PersonalizedEntrepreneurshipDTO {
    private String namePersonalized;
    private int quantityPersonalized;
    public String getNamePersonalized() {
        return namePersonalized;
    }
    public void setNamePersonalized(String namePersonalized) {
        this.namePersonalized = namePersonalized;
    }
    public int getQuantityPersonalized() {
        return quantityPersonalized;
    }
    public void setQuantityPersonalized(int quantityPersonalized) {
        this.quantityPersonalized = quantityPersonalized;
    }
}
