package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "kursi")
@Getter
@Setter
public class Kursi {
    @EmbeddedId
    @AttributeOverrides
            ({
                    @AttributeOverride(name = "idJadwal", column = @Column(name = "id_jadwal")),
                    @AttributeOverride(name = "noKursi", column = @Column(name = "no_kursi"))
            })
    private KursiPk idKursi;
    @Column(name = "id_nota")
    private Long idNota;

}
