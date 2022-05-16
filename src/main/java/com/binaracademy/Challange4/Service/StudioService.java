package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.StudioDto;
import com.binaracademy.Challange4.Entity.Studio;
import com.binaracademy.Challange4.Repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudioService {
    @Autowired
    StudioRepository studioRepository;
    public ResponseEntity<?> ls_studio(){
        List<Studio> studio = studioRepository.findAll();
        try {
            studioRepository.findAll();
            return new ResponseEntity<>(studio,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }
    public ResponseEntity<?> ls_studio(Long id){
        Optional<Studio> studio = studioRepository.findById(id);
        try {
            studioRepository.findById(id);
            return new ResponseEntity<>(studio,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }
    public ResponseEntity<?> set_studio(StudioDto studioDto){
        Studio studio = new Studio();
        try {
            studio.setIdStudio(studioDto.getIdStudio());
            studio.setStudio(studioDto.getStudio());
            studio.setKursi(studioDto.getKursi());
            if(Objects.isNull(studio.getIdStudio())){
                studioRepository.save(studio);
                return new ResponseEntity<>(studio, HttpStatus.CREATED);
            }else if(studioRepository.existsById(studio.getIdStudio())){
                studioRepository.save(studio);
                return new ResponseEntity<>(studio, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(studio, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }
    }
    public boolean delete_studio(Long id){
        if(studioRepository.existsById(id)){
            studioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
