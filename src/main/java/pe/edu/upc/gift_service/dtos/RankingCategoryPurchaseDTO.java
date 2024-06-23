package pe.edu.upc.gift_service.dtos;

public class RankingCategoryPurchaseDTO {
    String nameCategory;
    int total;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
