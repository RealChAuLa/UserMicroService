package com.example.UserSrevice.Service;


import com.example.UserSrevice.Data.User;
import com.example.UserSrevice.Data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkExistUsername(String c_username) {
        return userRepository.existsByUserName(c_username);
    }

    public User saveUser(User user1) {
        if (checkExistUsername(user1.getC_username())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user1);
    }

    public boolean authenticate(String c_username, String c_password) {
        Optional<User> userOptional = userRepository.findByUserName(c_username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getC_password().equals(c_password);
        }
        return false;
    }

//    public  List<User> getuserdetilsbyname(String c_username){
//        return userRepository.finduserdetilsbyname(c_username);
//    }


}
