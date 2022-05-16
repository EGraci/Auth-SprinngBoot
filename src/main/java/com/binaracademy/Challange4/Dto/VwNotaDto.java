package com.binaracademy.Challange4.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class VwNotaDto {
    private Long idJadwal;
    private Long idNota;
    private Integer noKursi;
    private String nama;
    private String film;
    private String studio;
    private Date tanggal;
    private Time mulai;
    private Time selesai;
    private BigDecimal harga;
}
