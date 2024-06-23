package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;
    @Column(name = "emissionDate", nullable = false)
    private LocalDate emissionDate;
    @Column(name = "message", nullable = false, length = 200)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users usEr;

    public Notification() {
    }

    public Notification(int idNotification, LocalDate emissionDate, String message, Users usEr) {
        this.idNotification = idNotification;
        this.emissionDate = emissionDate;
        this.message = message;
        this.usEr = usEr;
    }

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
