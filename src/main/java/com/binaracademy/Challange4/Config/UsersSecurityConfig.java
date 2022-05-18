package com.binaracademy.Challange4.Config;

import com.binaracademy.Challange4.Entity.AppUser;
import com.binaracademy.Challange4.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableWebSecurity
public class UsersSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // algorithm password encoder
        // return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        // set user on database to spring security
        final Properties users = new Properties();
        for(AppUser i: appUserRepository.findAll()){
            users.put(i.getUsername(), String.format("%s,%s,enabled",i.getPassword(),i.getRole()));
        }
        return new InMemoryUserDetailsManager(users);
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // URL PERMISSION
//        http.authorizeHttpRequests().antMatchers("/login","/singup").permitAll();
//        http.authorizeHttpRequests().antMatchers("/api/**").hasRole("ADMIN").and().csrf().disable();
//        http.authorizeHttpRequests().antMatchers("/api/reservasi/**","/api/jadwal/vw").hasRole("CUSTOMER").and().csrf().disable();
//    }
}
