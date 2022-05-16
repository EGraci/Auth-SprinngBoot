package com.binaracademy.Challange4.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class JadwalFilmDto {
    private String nmFilm;
    private String nmStudio;
    private BigDecimal hgTiket;
    private Date tglTayang;
    private Time jmMulai;
    private Time jmSelesai;
}
