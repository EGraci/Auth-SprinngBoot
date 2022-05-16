package com.binaracademy.Challange4.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;

@Getter
@Setter
public class JadwalDto {
    private Long idJadwal;
    private Long kdFilm;
    private Long idStudio;
    private Date tglTayang;
    private Time jmMulai;
    private Time jmSelesai;
    private BigDecimal hgTiket;
}
