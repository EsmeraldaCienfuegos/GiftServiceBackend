package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReviews;
    @Column(name = "dateReviews", nullable = false)
    private LocalDate dateReviews;
    @Column(name = "scoreReviews", nullable = false)
    private double scoreReviews;
    @Column(name = "commentReviews", nullable = false)
    private String commentReviews;
    @Column(name = "titleReviews", nullable = false)
    private String titleReviews;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Reviews() {
    }

    public Reviews(int idReviews, LocalDate dateReviews, double scoreReviews, String commentReviews, String titleReviews, Users users, Product product) {
        this.idReviews = idReviews;
        this.dateReviews = dateReviews;
        this.scoreReviews = scoreReviews;
        this.commentReviews = commentReviews;
        this.titleReviews = titleReviews;
        this.users = users;
        this.product = product;
    }

    public String getTitleReviews() {
        return titleReviews;
    }

    public void setTitleReviews(String titleReviews) {
        this.titleReviews = titleReviews;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
