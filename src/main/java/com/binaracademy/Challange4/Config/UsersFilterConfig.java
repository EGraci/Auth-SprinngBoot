package com.binaracademy.Challange4.Config;

import com.binaracademy.Challange4.Entity.AppUser;
import com.binaracademy.Challange4.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

public class UsersFilterConfig implements UserDetailsService {
    private final Logger logger = LogManager.getLogger(UsersFilterConfig.class);
    private final PasswordEncoder passwordEncoder;
    @Autowired
    AppUserRepository appUserRepository;

    public UsersFilterConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // filter user with database
        AppUser user = appUserRepository.findByUsername(username);
        if(appUserRepository.existsByUsername(username)){
            logger.info(username+ "found .!");
        }else{
            logger.error("user not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new  org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);
    }

}
