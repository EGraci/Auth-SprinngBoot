package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "vw_nota")
@Getter
@Setter
public class VwNota {
    @EmbeddedId
    @AttributeOverrides
            ({
                    @AttributeOverride(name = "idJadwal", column = @Column(name = "id_jadwal")),
                    @AttributeOverride(name = "noKursi", column = @Column(name = "no_kursi"))
            })
    private VwNotaPk vwNotaPk;
    @Column(name = "id_nota")
    private Long idNota;
    @Column(name = "studio")
    private String studio;
    @Column(name = "username")
    private String nama;
    @Column(name = "nm_film")
    private String film;
    @Column(name = "tgl_tayang")
    private Date tanggal;
    @Column(name = "jm_mulai")
    private Time mulai;
    @Column(name = "jm_selesai")
    private Time selesai;
    @Column(name = "hg_tiket")
    private BigDecimal harga;
}

