package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "vw_jadwal")
@Getter
@Setter
public class VwJadwal {
    @Id
    @Column(name = "id_jadwal")
    private Long idJadwal;
    @Column(name = "kd_film")
    private Long kdFilm;
    @Column(name = "id_studio")
    private Long idStudio;
    @Column(name = "film")
    private String film;
    @Column(name = "tiket")
    private BigDecimal tiket;
    @Column(name = "tanggal")
    private Date tanggal;
    @Column(name = "mulai")
    private Time mulai;
    @Column(name = "selesai")
    private Time selesai;
    @Column(name = "studio")
    private String studio;
}
