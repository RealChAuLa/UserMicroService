package com.example.UserSrevice.Data;


import javax.persistence.*;

@Entity
@Table(name = "cuser_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "c_username")
    private  String userName;

    @Column(name = "c_password")
    private String c_password;

    @Column(name = "c_email")
    private String c_email;

    @Column(name = "c_address")
    private String c_address;

    @Column (name ="c_favcount")
    private int c_favcount;

    public int getC_favcount() {
        return c_favcount;
    }

    public int getId() {
        return id;
    }

    public String getC_password() {
        return c_password;
    }

    public String getC_username() {
        return userName;
    }

    public String getC_email() {
        return c_email;
    }

    public String getC_address() {
        return c_address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public void setC_username(String c_username) {
        this.userName = c_username;
    }

    public void setC_favcount(int c_favcount) {
        this.c_favcount = c_favcount;
    }

    public User() {
    }
}
