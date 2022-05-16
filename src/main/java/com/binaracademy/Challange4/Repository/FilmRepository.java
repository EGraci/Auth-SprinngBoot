package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FilmRepository extends JpaRepository<Film,Long> {
}
