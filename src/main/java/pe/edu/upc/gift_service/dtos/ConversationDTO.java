package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Entrepreneurship;
import pe.edu.upc.gift_service.entities.Users;

import java.time.LocalDate;

public class ConversationDTO {
    private int idConversation;
    private LocalDate dateConversation;
    private String textConversation;
    private Entrepreneurship entrepreneurship;
    private Users users;

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
