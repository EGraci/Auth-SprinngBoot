package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.AppUserDto;
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

    public ResponseEntity<?> add_user(AppUserDto appUser){
        AppUser user = new AppUser();
        if(appUserRepository.existsByUsername(appUser.getUsername())){
            return new ResponseEntity<>("userName error.user sudah ada", HttpStatus.BAD_REQUEST);
        }
        user.setUsername(appUser.getUsername());
        user.setEmail(appUser.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        user.setRole("CUSTOMER");
        appUserRepository.save(user);
        return new ResponseEntity<>(appUser,HttpStatus.CREATED);
    }
    public AppUser user(String username){
        return appUserRepository.findByUsername(username);
    }
}
