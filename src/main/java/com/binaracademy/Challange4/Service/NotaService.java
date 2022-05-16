package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Entity.VwNota;
import com.binaracademy.Challange4.Repository.VwNotaRepository;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Getter
@Setter
public class NotaService {
    @Autowired
    VwNotaRepository vwNotaRepository;
    private String lokasi;
    NotaService(){
        String getOs = System.getProperty("os.name").toLowerCase();
        if(getOs.contains("win")){
            this.setLokasi(System.getProperty("java.io.tmpdir")+"\\");
        }else{
            this.setLokasi(System.getProperty("java.io.tmpdir")+"/");
        }
    }
//    public String report(String format, Long nota) throws Exception{
//        Optional<VwNota> lsVwNota = vwNotaRepository.findByIdNota(nota);
//        File file = ResourceUtils.getFile("D:\\Java Workspace\\Challange4\\src\\main\\resources\\TiketFilm.jrxml");
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(Collections.singleton(lsVwNota),false);
//
//        Map<String,Object> paramater = new HashMap<>();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramater,jrBeanCollectionDataSource);
//
//        if (format.equalsIgnoreCase("pdf")){
//            JasperExportManager.exportReportToPdfFile(jasperPrint,this.getLokasi()+"\\Nota.pdf");
//        }
//        return "File have Generated, path : "+ this.getLokasi();
//    }

}
