package com.binaracademy.Challange4.Controller;

import com.binaracademy.Challange4.Service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nota")
public class NotaController {
    @Autowired
    NotaService notaService;

    @GetMapping(path = "/{nota}")
    public ResponseEntity<?> view_nota(@PathVariable("nota") Long nota){
        return notaService.vw_nota(nota);
    }
    @GetMapping(value = "/{format}/{nota}", produces = "application/pdf")
    public byte[] view_nota(@PathVariable("format") String format, @PathVariable("nota") Long nota) throws Exception {
        return notaService.report(format,nota);
    }
}
