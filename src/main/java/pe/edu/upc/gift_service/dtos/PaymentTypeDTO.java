package pe.edu.upc.gift_service.dtos;

public class PaymentTypeDTO {
    private int idPayment_Type;
    private  String namePayment_Type;

    public int getIdPayment_Type() {
        return idPayment_Type;
    }

    public void setIdPayment_Type(int idPayment_Type) {
        this.idPayment_Type = idPayment_Type;
    }

    public String getNamePayment_Type() {
        return namePayment_Type;
    }

    public void setNamePayment_Type(String namePayment_Type) {
        this.namePayment_Type = namePayment_Type;
    }
}
