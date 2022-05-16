package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Dto.UserDto;
import com.binaracademy.Challange4.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AppUserController {
    @Autowired
    private AppUserService userService;

    @GetMapping(path = "/")
    public ResponseEntity<?> view_user(){
        return userService.ls_user();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> view_user(@PathVariable("id") Long id){
        return userService.ls_user(id);
    }
    @PostMapping(path ="/")
    public ResponseEntity<?> add_user(@RequestBody UserDto userDto){
        return userService.set_user(userDto);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> set_user(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        userDto.setIdUser(id);
        return userService.set_user(userDto);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete_user(@PathVariable("id") Long id){
        if(userService.delete_user(id)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
