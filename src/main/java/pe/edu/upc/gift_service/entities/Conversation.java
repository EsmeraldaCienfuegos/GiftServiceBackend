package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Conversation")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idConversation;
    @Column(name = "dateConversation", nullable = false)
    private LocalDate dateConversation;
    @Column(name = "textConversation", nullable = false)
    private String textConversation;

    @ManyToOne
    @JoinColumn(name = "Entrepreneurship_id")
    private Entrepreneurship entrepreneurship;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;

    public Conversation() {
    }

    public Conversation(int idConversation, LocalDate dateConversation, String textConversation, Entrepreneurship entrepreneurship, Users users) {
        this.idConversation = idConversation;
        this.dateConversation = dateConversation;
        this.textConversation = textConversation;
        this.entrepreneurship = entrepreneurship;
        this.users = users;
    }

    public int getIdConversation() {
        return idConversation;
    }

    public void setIdConversation(int idConversation) {
        this.idConversation = idConversation;
    }

    public LocalDate getDateConversation() {
        return dateConversation;
    }

    public void setDateConversation(LocalDate dateConversation) {
        this.dateConversation = dateConversation;
    }

    public String getTextConversation() {
        return textConversation;
    }

    public void setTextConversation(String textConversation) {
        this.textConversation = textConversation;
    }

    public Entrepreneurship getEntrepreneurship() {
        return entrepreneurship;
    }

    public void setEntrepreneurship(Entrepreneurship entrepreneurship) {
        this.entrepreneurship = entrepreneurship;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
