package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.FilmDto;
import com.binaracademy.Challange4.Dto.RawJadwalFilmDto;
import com.binaracademy.Challange4.Entity.Film;
import com.binaracademy.Challange4.Repository.FilmRepository;
import com.binaracademy.Challange4.Repository.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    JadwalRepository jadwalRepository;

    public ResponseEntity<?> ls_film(){
        List<Film> film = filmRepository.findAll();
        try{
            filmRepository.findAll();
            return new ResponseEntity<>(film, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }

    }
    public ResponseEntity<?> ls_film(Long kd){
        Optional<Film> film = filmRepository.findById(kd);
        try {
            filmRepository.findById(kd);
            return new ResponseEntity<>(film,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }
    }
    public ResponseEntity<?> set_film(FilmDto filmDto){
        Film film = new Film();
        try {
            film.setKdFilm(filmDto.getKdFilm());
            film.setNmFilm(filmDto.getNmFilm());
            film.setStatus(filmDto.getStatus());
            if(Objects.isNull(film.getKdFilm())){
                filmRepository.save(film);
                return new ResponseEntity<>(film,HttpStatus.CREATED);
            }else if(filmRepository.existsById(film.getKdFilm())){
                filmRepository.save(film);
                return new ResponseEntity<>(film,HttpStatus.OK);
            }else{
                return new ResponseEntity<>(film,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }

    }
    public Boolean delete_film(Long kd){
        if(filmRepository.existsById(kd)){
            filmRepository.deleteById(kd);
            if(jadwalRepository.existsJadwalByKdFilm(kd)){
                jadwalRepository.deleteJadwalByKdFilm(kd);
            }
            return true;
        }
        return  false;
    }
    public ResponseEntity<?> raw_jadwal_film(Long kd){
        RawJadwalFilmDto rawJadwalFilmDto = new RawJadwalFilmDto();
        try {
            Optional<Film> film = filmRepository.findById(kd);
            rawJadwalFilmDto.setKdFilm(film.get().getKdFilm());
            rawJadwalFilmDto.setNmFilm(film.get().getNmFilm());
            rawJadwalFilmDto.setStatus(film.get().getStatus());
            rawJadwalFilmDto.setJadwal(jadwalRepository.findByKdFilm(kd));
            return new ResponseEntity<>(rawJadwalFilmDto, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }
    }

}
