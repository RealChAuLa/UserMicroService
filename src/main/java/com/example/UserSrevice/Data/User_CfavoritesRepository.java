package com.example.UserSrevice.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface User_CfavoritesRepository extends JpaRepository<User_Cfavorites, Integer> {

    @Query("SELECT u FROM User_Cfavorites u WHERE u.user_namefavorite = ?1 AND u.clothe_idfavorite = ?2")
    List<User_Cfavorites> findFavoriteOrNot(String user_namefavorite, int clothe_idfavorite);

    @Query("SELECT u FROM User_Cfavorites u WHERE u.user_namefavorite = ?1 ")
    List<User_Cfavorites> FindAllfav(String user_namefavorite);

    @Query("SELECT COUNT(u) FROM User_Cfavorites u WHERE u.user_namefavorite = :user_namefavorite")
    int countByUsername(String user_namefavorite);


}
