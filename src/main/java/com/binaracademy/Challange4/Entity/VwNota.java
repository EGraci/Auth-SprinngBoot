package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "vw_nota")
@Getter
@Setter
public class VwNota {
    @Id
    @Column(name = "id")
    private BigInteger id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "film")
    private String film;
    @Column(name = "studio")
    private String studio;
    @Column(name = "kursi")
    private Integer kursi;
    @Column(name = "tanggal")
    private Date tanggal;
    @Column(name = "mulai")
    private Time mulai;
    @Column(name = "selesai")
    private Time selesai;
    @Column(name = "total")
    private BigDecimal total;
}
