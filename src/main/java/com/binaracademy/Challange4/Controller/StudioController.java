package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Dto.StudioDto;
import com.binaracademy.Challange4.Service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studio")
public class StudioController {
    @Autowired
    StudioService studioService;

    @GetMapping(path = "/")
    public ResponseEntity<?> view_studio(){
        return studioService.ls_studio();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> view_studio(@PathVariable("id") Long id){
        return studioService.ls_studio(id);
    }
    @PostMapping(path = "/")
    public ResponseEntity<?> add_studio(@RequestBody StudioDto studioDto){
        return studioService.set_studio(studioDto);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> up_studio(@PathVariable("id") Long id, @RequestBody StudioDto studioDto){
        studioDto.setIdStudio(id);
        return studioService.set_studio(studioDto);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete_studio(@PathVariable("id") Long id){
        if(studioService.delete_studio(id)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
