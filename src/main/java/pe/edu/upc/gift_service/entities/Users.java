package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "UserWeb")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(length = 30, unique = true)
    private String username;
    @Column(length = 200)
    private String password;

    private Boolean enabled;
    @Column(name = "realname", nullable = false, length = 50)
    private String realname;
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "mail", nullable = false, length = 50)
    private String mail;
    @Column(name = "contact", nullable = false)
    private int contact;
    @Column(name = "address", nullable = false, length = 30)
    private String address;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City ciTy;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public Users() {
    }

    public Users(int idUser, String username, String password, Boolean enabled, String realname, String lastName, String mail, int contact, String address, City ciTy, List<Role> roles) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.realname = realname;
        this.lastName = lastName;
        this.mail = mail;
        this.contact = contact;
        this.address = address;
        this.ciTy = ciTy;
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCiTy() {
        return ciTy;
    }

    public void setCiTy(City ciTy) {
        this.ciTy = ciTy;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}


