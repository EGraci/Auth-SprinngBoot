package com.binaracademy.Challange4.Service;

import com.binaracademy.Challange4.Dto.VwNotaDto;
import com.binaracademy.Challange4.Entity.VwNota;
import com.binaracademy.Challange4.Repository.VwNotaRepository;
import lombok.Getter;
import lombok.Setter;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.*;

@Service
public class NotaService {
    @Autowired
    VwNotaRepository vwNotaRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;
    ApplicationContext context;


    public ResponseEntity<?> vw_nota(Long nota){
        List<VwNotaDto> lsVwNota = this.vw_nota(vwNotaRepository.findByIdNota(nota));
        return new ResponseEntity<>(lsVwNota, HttpStatus.ACCEPTED);
    }
    public byte[] report(String format, Long nota) throws Exception{
        List<VwNotaDto> lsVwNota = this.vw_nota(vwNotaRepository.findByIdNota(nota));
//        Connection conn = jdbcTemplate.getDataSource().getConnection();
        InputStream inputStream = getClass().getResourceAsStream("/TiketFilm.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(lsVwNota,false);
//        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRDataSource datasource = new JREmptyDataSource();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("parameters", nota);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
        byte[] result = new byte[0];
        if(Objects.equals(format, "pdf")){
            result = JasperExportManager.exportReportToPdf(jasperPrint);
        }
        return result;
    }
    private List<VwNotaDto> vw_nota(List<VwNota> vwNota){
        List<VwNotaDto> lsVwNotaDto = new ArrayList<>();
        for(VwNota i : vwNota){
            VwNotaDto temp = new VwNotaDto();
            temp.setIdJadwal(i.getVwNotaPk().getIdJadwal());
            temp.setNoKursi(i.getVwNotaPk().getNoKursi());
            temp.setIdNota(i.getIdNota());
            temp.setNama(i.getNama());
            temp.setFilm(i.getFilm());
            temp.setStudio(i.getStudio());
            temp.setTanggal(i.getTanggal());
            temp.setMulai(i.getMulai());
            temp.setSelesai(i.getSelesai());
            temp.setHarga(i.getHarga());
            lsVwNotaDto.add(temp);
        }
        return lsVwNotaDto;
    }

}
