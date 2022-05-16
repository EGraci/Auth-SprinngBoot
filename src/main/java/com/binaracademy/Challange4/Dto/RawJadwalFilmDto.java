package com.binaracademy.Challange4.Dto;

import com.binaracademy.Challange4.Entity.Jadwal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RawJadwalFilmDto {
    private Long kdFilm;
    private String nmFilm;
    private Boolean status;
    private List<Jadwal> jadwal;
}
