package pe.edu.upc.gift_service.dtos;

import pe.edu.upc.gift_service.entities.Product;
import pe.edu.upc.gift_service.entities.Users;

import java.time.LocalDate;

public class ReviewsDTO {
    private int idReviews;
    private LocalDate dateReviews;
    private double scoreReviews;
    private String commentReviews;
    private String titleReviews;
    private Users users;
    private Product product;

    public int getIdReviews() {
        return idReviews;
    }

    public void setIdReviews(int idReviews) {
        this.idReviews = idReviews;
    }

    public LocalDate getDateReviews() {
        return dateReviews;
    }

    public void setDateReviews(LocalDate dateReviews) {
        this.dateReviews = dateReviews;
    }

    public double getScoreReviews() {
        return scoreReviews;
    }

    public void setScoreReviews(double scoreReviews) {
        this.scoreReviews = scoreReviews;
    }

    public String getCommentReviews() {
        return commentReviews;
    }

    public void setCommentReviews(String commentReviews) {
        this.commentReviews = commentReviews;
    }

    //public Users getUser() {return users;    }
    //public void setUser(Users users) { this.users = users;    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getTitleReviews() {
        return titleReviews;
    }

    public void setTitleReviews(String titleReviews) {
        this.titleReviews = titleReviews;
    }
}
