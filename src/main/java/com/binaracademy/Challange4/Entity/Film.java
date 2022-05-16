package com.binaracademy.Challange4.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kd_film")
    private Long kdFilm;
    @Column(name = "nm_film")
    private String nmFilm;
    @Column(name = "status")
    private Boolean status;
}
