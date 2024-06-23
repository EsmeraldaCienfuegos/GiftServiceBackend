package pe.edu.upc.gift_service.dtos;

public class RankingPaymentTypesUsedDTO {
    String namePaymentType;
    int total;

    public String getNamePaymentType() {
        return namePaymentType;
    }

    public void setNamePaymentType(String namePaymentType) {
        this.namePaymentType = namePaymentType;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
