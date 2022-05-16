package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.JadwalDto;
import com.binaracademy.Challange4.Dto.JadwalFilmDto;
import com.binaracademy.Challange4.Entity.Film;
import com.binaracademy.Challange4.Entity.Jadwal;
import com.binaracademy.Challange4.Entity.Studio;
import com.binaracademy.Challange4.Entity.VwJadwal;
import com.binaracademy.Challange4.Repository.FilmRepository;
import com.binaracademy.Challange4.Repository.JadwalRepository;
import com.binaracademy.Challange4.Repository.StudioRepository;
import com.binaracademy.Challange4.Repository.VwJadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JadwalService {
    @Autowired
    JadwalRepository jadwalRepository;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    StudioRepository studioRepository;
    @Autowired
    VwJadwalRepository vwJadwalRepository;

    public ResponseEntity<?> ls_jadwal_film(){
        List<JadwalFilmDto> lsJadwal = new ArrayList<>();
        try {
            List<Jadwal> raw = jadwalRepository.findAll();
            for (Jadwal i : raw) {
                JadwalFilmDto jadwal = new JadwalFilmDto();
                Optional<Film> film = filmRepository.findById(i.getKdFilm());
                Optional<Studio> studio = studioRepository.findById(i.getIdStudio());
                jadwal.setNmFilm(film.get().getNmFilm());
                jadwal.setNmStudio(studio.get().getStudio());
                jadwal.setHgTiket(i.getHgTiket());
                jadwal.setTglTayang(i.getTglTayang());
                jadwal.setJmMulai(i.getJmMulai());
                jadwal.setJmSelesai(i.getJmSelesai());
                lsJadwal.add(jadwal);
            }
            return new ResponseEntity<>(lsJadwal, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }


    }
    public ResponseEntity<?> ls_jadwal(){
        List<Jadwal> jadwal = jadwalRepository.findAll();
        try {
            jadwalRepository.findAll();
            return new ResponseEntity<>(jadwal, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }
    public ResponseEntity<?> ls_jadwal(Long id){
        Optional<Jadwal> jadwal = jadwalRepository.findById(id);
        try{
             jadwalRepository.findById(id);
            return new ResponseEntity<>(jadwal, HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }

    }
    public ResponseEntity<?> set_jadwal(JadwalDto jadwalDto){
        Jadwal jadwal = new Jadwal();
        try{
            jadwal.setIdJadwal(jadwalDto.getIdJadwal());
            jadwal.setJmMulai(jadwalDto.getJmMulai());
            jadwal.setJmSelesai(jadwalDto.getJmSelesai());
            jadwal.setTglTayang(jadwalDto.getTglTayang());
            jadwal.setHgTiket(jadwalDto.getHgTiket());
            if(filmRepository.existsById(jadwalDto.getKdFilm()) && studioRepository.existsById(jadwalDto.getIdStudio()) && Objects.isNull(jadwalDto.getIdJadwal())){
                jadwal.setKdFilm(jadwalDto.getKdFilm());
                jadwal.setIdStudio(jadwalDto.getIdStudio());
                jadwal = jadwalRepository.save(jadwal);
                return new ResponseEntity<>(jadwal, HttpStatus.CREATED);
            }else if(filmRepository.existsById(jadwalDto.getKdFilm()) && studioRepository.existsById(jadwalDto.getIdStudio()) && jadwalRepository.existsById(jadwalDto.getIdJadwal())){
                jadwal.setKdFilm(jadwalDto.getKdFilm());
                jadwal.setIdStudio(jadwalDto.getIdStudio());
                jadwal = jadwalRepository.save(jadwal);
                return new ResponseEntity<>(jadwal, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(jadwal, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.EXPECTATION_FAILED);
        }


    }
    public Boolean delete_jadwal(Long id) {
        if (jadwalRepository.existsById(id)) {
            jadwalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseEntity<?> ls_vw_jadwal() {
        List<VwJadwal> vwJadwals = vwJadwalRepository.findAll();
        try {
            vwJadwalRepository.findAll();
            return new ResponseEntity<>(vwJadwals,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }
    }
}
