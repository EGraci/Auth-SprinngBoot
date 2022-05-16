package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.KursiDto;
import com.binaracademy.Challange4.Dto.PesanDto;
import com.binaracademy.Challange4.Dto.StatusKursiDto;
import com.binaracademy.Challange4.Entity.*;
import com.binaracademy.Challange4.Repository.KursiRepository;
import com.binaracademy.Challange4.Repository.NotaRepository;
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
public class ReservasiService {
    @Autowired
    VwJadwalRepository vwJadwalRepository;
    @Autowired
    KursiRepository kursiRepository;
    @Autowired
    StudioRepository studioRepository;
    @Autowired
    NotaRepository notaRepository;

    public ResponseEntity<?> set_reservasi(PesanDto pesanDto){
        try {
            Nota nota = new Nota();
            pesanDto.setIdNota(System.currentTimeMillis());
            nota.setIdNota(System.currentTimeMillis());
            nota.setIdUser(pesanDto.getIdUser());
            nota.setTotal(pesanDto.getTotal());
            nota.setBayar(pesanDto.getBayar());
            List<KursiDto> ls_kursi = new ArrayList<>();
            for(KursiDto i : pesanDto.getKursi()){
                KursiPk kursiPk = new KursiPk();
                kursiPk.setNoKursi(i.getNoKursi());
                kursiPk.setIdJadwal(i.getIdJadwal());
                if(kursiRepository.existsById(kursiPk)){
                    Optional<Kursi> op_kursi = kursiRepository.findById(kursiPk);
                    if(Objects.nonNull(op_kursi.get().getIdNota())){
                        continue;
                    }
                }
                Kursi kursi = new Kursi();
                kursi.setIdKursi(kursiPk);
                kursi.setIdNota(pesanDto.getIdNota());
                kursiRepository.save(kursi);
                ls_kursi.add(i);
            }
            pesanDto.setKursi(ls_kursi);
            notaRepository.save(nota);
            return  new ResponseEntity<>(pesanDto,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.EXPECTATION_FAILED);
        }
    }

    public ResponseEntity<?> ls_kursi_jadwal(Long id) {
        StatusKursiDto statusKursiDto = new StatusKursiDto();
        try {
            List<Integer> kosong = new ArrayList<>();
            List<Integer> pesan = new ArrayList<>();
            if(vwJadwalRepository.existsById(id)){
                Optional<VwJadwal> vwJadwal = vwJadwalRepository.findById(id);
                statusKursiDto.setFilm(vwJadwal.get().getFilm());
                statusKursiDto.setStudio(vwJadwal.get().getStudio());
                Optional<Studio> studio = studioRepository.findById(id);
                for(int i = 1; i <= studio.get().getKursi(); i++){
                    if(kursiRepository.countNoKursi(i,vwJadwal.get().getIdJadwal()) > 0){
                        pesan.add(i);
                    }else{
                       kosong.add(i);
                    }
                }
                statusKursiDto.setKosong(kosong);
                statusKursiDto.setPesan(pesan);
            }
            return new ResponseEntity<>(statusKursiDto,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.EXPECTATION_FAILED);
        }
    }
}
