package com.example.UserSrevice.Controller;


import com.example.UserSrevice.Data.User;
import com.example.UserSrevice.Data.User_Cfavorites;
import com.example.UserSrevice.Service.UserService;
import com.example.UserSrevice.Service.User_CfavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private User_CfavoritesService user_cfavoritesService;
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> createUser(@RequestBody User user1) {
        try {
            userService.saveUser(user1);
            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user1) {
        boolean isAuthenticated = userService.authenticate(user1.getC_username(), user1.getC_password());
        if (isAuthenticated) {
            // Return the username on successful login
            return ResponseEntity.ok(user1.getC_username());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    @GetMapping(path = "/usersall")
    public List<User_Cfavorites> getAllProducts() {
        return user_cfavoritesService.getAllProducts();
    }

    @GetMapping(path = "/GetFavOrNot")
    public List<User_Cfavorites> GettFindFavoriteOrNot(@RequestParam("user_namefavorite") String user_namefavorite, @RequestParam("clothe_idfavorite") int clothe_idfavorite) {
        List<User_Cfavorites> favorites = user_cfavoritesService.findFavoriteOrNot(user_namefavorite, clothe_idfavorite);
        return favorites;
    }

    @GetMapping("/GetAllUserfav")
    public List<User_Cfavorites> getAllFavorites(@RequestParam("userNameFavorite") String userNameFavorite) {
        return user_cfavoritesService.findAllFavorites(userNameFavorite);
    }

    @PostMapping(path = "/Addtofavoerite")
    public User_Cfavorites SaveFavClothe(@RequestBody User_Cfavorites userCfavorites1) {
        return user_cfavoritesService.SaveFavClothe(userCfavorites1);
    }

    @DeleteMapping("/favoritedelete/{id}")
    public void deletefavById(@PathVariable int id) {
        user_cfavoritesService.deletefav(id);
    }

    @GetMapping("/usernameFavCount")
    public int getUsernameCount(@RequestParam String username) {
        return user_cfavoritesService.getUsernameCount(username);
    }
}
