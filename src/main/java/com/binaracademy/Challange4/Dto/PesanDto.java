package com.binaracademy.Challange4.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PesanDto {
    private Long idNota;
    private Long idUser;
    private BigDecimal total;
    private BigDecimal bayar;
    private List<KursiDto> kursi;
}
