package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class KursiPk implements Serializable {
    private Long idJadwal;
    private Integer noKursi;
}
