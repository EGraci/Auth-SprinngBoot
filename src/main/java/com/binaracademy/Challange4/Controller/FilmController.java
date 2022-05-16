package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Dto.FilmDto;
import com.binaracademy.Challange4.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @GetMapping(path = "/")
    public ResponseEntity<?> view_film(){
        return  filmService.ls_film();
    }
    @GetMapping(path = "/{kd}")
    public ResponseEntity<?> view_film(@PathVariable("kd") Long kd){
        return  filmService.ls_film(kd);
    }
    @GetMapping(path = "/raw/{kd}")
    public ResponseEntity<?> raw_film(@PathVariable("kd") Long kd){
        return  filmService.raw_jadwal_film(kd);
    }
    @PostMapping(path = "/")
    public ResponseEntity<?> add_film(@RequestBody FilmDto filmDto){
        return filmService.set_film(filmDto);
    }
    @PutMapping(path = "/{kd}")
    public ResponseEntity<?> up_film(@PathVariable("kd") Long kd, @RequestBody FilmDto filmDto){
        filmDto.setKdFilm(kd);
        return filmService.set_film(filmDto);
    }
    @DeleteMapping(path = "/{kd}")
    public ResponseEntity<?> delete_film(@PathVariable("kd") Long kd){
        if(filmService.delete_film(kd)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
