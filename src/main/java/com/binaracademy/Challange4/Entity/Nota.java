package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "nota")
@Getter
@Setter
public class Nota {
    @Id
    @Column(name = "id_nota")
    private Long idNota;
    @Column(name = "id_user")
    private Long idUser;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "bayar")
    private BigDecimal bayar;
}
