package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Users;

import java.time.LocalDate;

public class NotificationDTO {
    private int idNotification;
    private LocalDate emissionDate;
    private String message;

    private Users usEr;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
        this.emissionDate = emissionDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Users getUsEr() {
        return usEr;
    }

    public void setUsEr(Users usEr) {
        this.usEr = usEr;
    }
}
