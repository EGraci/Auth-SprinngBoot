package com.binaracademy.Challange4.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StatusKursiDto {
    private String film;
    private String studio;
    private List<Integer> kosong;
    private List<Integer> pesan;
}
