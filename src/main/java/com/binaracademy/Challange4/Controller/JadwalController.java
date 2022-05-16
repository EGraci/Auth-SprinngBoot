package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Dto.JadwalDto;
import com.binaracademy.Challange4.Service.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/jadwal")
public class JadwalController {
    @Autowired
    JadwalService jadwalService;
    @GetMapping(path = "/film/")
    public ResponseEntity<?> view_jadwal_film(){
        return jadwalService.ls_jadwal_film();
    }
    @GetMapping(path="/vw/")
    public ResponseEntity<?> view_vw_jadwal(){
        return jadwalService.ls_vw_jadwal();
    }
    @GetMapping(path = "/")
    public ResponseEntity<?> view_jadwal(){
        return jadwalService.ls_jadwal();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> view_jadwal(@PathVariable("id") Long id){
        return jadwalService.ls_jadwal(id);
    }
    @PostMapping(path = "/")
    public ResponseEntity<?> add_jadwal(@RequestBody JadwalDto jadwalDto){
        return  jadwalService.set_jadwal(jadwalDto);
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<?> up_jadwal(@PathVariable("id") Long id, @RequestBody JadwalDto jadwalDto){
        jadwalDto.setIdJadwal(id);
        return jadwalService.set_jadwal(jadwalDto);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete_jadwal(@PathVariable("id") Long id){
        if(jadwalService.delete_jadwal(id)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
