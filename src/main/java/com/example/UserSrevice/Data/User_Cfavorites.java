package com.example.UserSrevice.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_clothefavorites")
public class User_Cfavorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name= "user_namefavorite")
    private  String user_namefavorite;

    @Column (name = "clothe_idfavorite")
    private  int  clothe_idfavorite;

    @Column (name = "Clothe_Name")
    private  String Clothe_Name;


    public String getClothe_Name() {
        return Clothe_Name;
    }



    public int getId() {
        return id;
    }

    public String getUser_namefavorite() {
        return user_namefavorite;
    }

    public int getClothe_idfavorite() {
        return clothe_idfavorite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_namefavorite(String user_namefavorite) {
        this.user_namefavorite = user_namefavorite;
    }

    public void setClothe_idfavorite(int clothe_idfavorite) {
        this.clothe_idfavorite = clothe_idfavorite;
    }

    public void setClothe_Name(String clothe_Name) {
        Clothe_Name = clothe_Name;
    }


    public User_Cfavorites() {
    }

}
