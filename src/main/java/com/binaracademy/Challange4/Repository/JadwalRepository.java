package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.Jadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface JadwalRepository extends JpaRepository<Jadwal,Long> {
    public boolean existsJadwalByKdFilm(Long kdFilm);
    public void deleteJadwalByKdFilm(Long kdFilm);
    public List<Jadwal> findByKdFilm(Long kdFilm);
}
