package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Entity.AppUser;
import com.binaracademy.Challange4.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<?> add_user(AppUser appUser){
        if(appUserRepository.existsByUsername(appUser.getUsername())){
            return new ResponseEntity<>("userName error.user sudah ada", HttpStatus.BAD_REQUEST);
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRole("CUSTOMER");
        appUserRepository.save(appUser);
        return new ResponseEntity<>(appUser,HttpStatus.CREATED);
    }
}
