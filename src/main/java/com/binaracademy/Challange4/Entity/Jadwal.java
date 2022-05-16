package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import  java.sql.Date;

@Entity
@Table(name = "jadwal")
@Getter
@Setter
public class Jadwal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jadwal")
    private Long idJadwal;
    @Column(name = "kd_film")
    private Long kdFilm;
    @Column(name = "id_studio")
    private Long idStudio;
    @Column(name = "tgl_tayang")
    private Date tglTayang;
    @Column(name = "jm_mulai")
    private Time jmMulai;
    @Column(name = "jm_selesai")
    private Time jmSelesai;
    @Column(name = "hg_tiket")
    private BigDecimal hgTiket;
}
