package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.UserDto;
import com.binaracademy.Challange4.Entity.AppUser;
import com.binaracademy.Challange4.Repository.AppUserRepository;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository userRepository;

    public ResponseEntity<?> ls_user(){
        List<AppUser> user = userRepository.findAll();
        try {
            userRepository.findAll();
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }
    // checked login
    /*
    if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
      // correct!
    } else {
      // bad login!
    }
     */
    public ResponseEntity<?> set_user(UserDto userDto){
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        AppUser user = new AppUser();
        try{
            user.setIdUser(userDto.getIdUser());
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncryptor.encryptPassword(userDto.getPassword()));
            if(Objects.isNull(user.getIdUser())){
                userRepository.save(user);
                return new ResponseEntity<>(user,HttpStatus.CREATED);
            }else if(userRepository.existsById(userDto.getIdUser())){
                userRepository.save(user);
                return new ResponseEntity<>(user,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }

    }
    public ResponseEntity<?> ls_user(Long id){
        Optional<AppUser> user = userRepository.findById(id);
        try {
            userRepository.findById(id);
            return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }

    }
    public Boolean delete_user(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
