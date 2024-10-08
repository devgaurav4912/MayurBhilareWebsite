package com.backend.MayurBhilareBackend.Service.Impl;
import com.backend.MayurBhilareBackend.Entity.User;
import com.backend.MayurBhilareBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    List<User> store = new ArrayList<>();
    @Autowired
    PasswordEncoder passwordEncoder;

//    public UserService() {
//        store.add(new User(1, "Gaurav Pawar", "gaurav@gmail.com","123","ADMIN"));
//        store.add(new User(2, "Mayur Pol", "mayur@gmail.com","123","ADMIN"));
//        store.add(new User(3, "Nitin Bone", "nitin@gmail.com","123","ADMIN"));
//        store.add(new User(4, "Omkar Raja", "omkar@gmail.com","123","ADMIN"));
//
//    }

    public List<User> getUsers(){
        return this.store;
    }


    public ResponseEntity<String> newUser(User user){

        Optional<User> existingUser = userRepository.findByUserName(user.getUserName());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);

        if (existingUser.isPresent()) {
            System.out.println("USER-NAME -2-> "+user.getUserName());
            return new ResponseEntity<>("Username already exists. Please choose a different username", HttpStatus.BAD_REQUEST);
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User Added  Successfully");

        }
    }



}
