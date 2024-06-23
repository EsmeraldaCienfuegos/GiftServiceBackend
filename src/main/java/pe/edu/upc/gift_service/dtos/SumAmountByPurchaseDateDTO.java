package pe.edu.upc.gift_service.dtos;

public class SumAmountByPurchaseDateDTO {
    private int totalProductSales;

    public SumAmountByPurchaseDateDTO(int totalProductSales) {
        this.totalProductSales = totalProductSales;
    }

    public int getTotalProductSales() {
        return totalProductSales;
    }

    public void setTotalProductSales(int totalProductSales) {
        this.totalProductSales = totalProductSales;
    }
}
