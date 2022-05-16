package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Dto.PesanDto;
import com.binaracademy.Challange4.Service.ReservasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservasi")
public class ReservasiController {
    @Autowired
    ReservasiService reservasiService;

    @GetMapping(path = "/jadwal/{id}")
    public ResponseEntity<?> get_kursi(@PathVariable("id") Long id){
        return reservasiService.ls_kursi_jadwal(id);
    }
    @PostMapping(path = "/")
    public ResponseEntity<?> add_reservasi(@RequestBody PesanDto pesanDto){
       return reservasiService.set_reservasi(pesanDto);
    }
}
