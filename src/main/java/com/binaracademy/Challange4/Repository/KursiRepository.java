package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.Kursi;
import com.binaracademy.Challange4.Entity.KursiPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface KursiRepository extends JpaRepository<Kursi, KursiPk> {
    @Query(value = "SELECT count(kursi.id_jadwal) as jml FROM kursi WHERE kursi.no_kursi = :no AND kursi.id_jadwal = :jd", nativeQuery = true)
    Long countNoKursi(@Param("no") int no, @Param("jd") Long jd);
}
