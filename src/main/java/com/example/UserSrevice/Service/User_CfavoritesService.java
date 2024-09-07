package com.example.UserSrevice.Service;

import com.example.UserSrevice.Data.User_Cfavorites;
import com.example.UserSrevice.Data.User_CfavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Service

public class User_CfavoritesService {

    @Autowired
    private User_CfavoritesRepository user_cfavoritesRepository;

    public List<User_Cfavorites> getAllProducts(){
        return user_cfavoritesRepository.findAll();
    }

    public List<User_Cfavorites> findFavoriteOrNot(String userNameFavorite, int clotheIdFavorite) {
        return user_cfavoritesRepository.findFavoriteOrNot(userNameFavorite, clotheIdFavorite);
    }

    public List<User_Cfavorites> findAllFavorites(String userNameFavorite) {
        return user_cfavoritesRepository.FindAllfav(userNameFavorite);
    }

    public  User_Cfavorites SaveFavClothe(User_Cfavorites fav1){
        return user_cfavoritesRepository.save(fav1);
    }

    public  String deletefav (int deleteid){
          user_cfavoritesRepository.deleteById(deleteid);
          return "deleted";
    }

    public int getUsernameCount(String user_namefavorite) {
        return user_cfavoritesRepository.countByUsername(user_namefavorite);
    }
}
