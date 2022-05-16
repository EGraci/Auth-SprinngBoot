package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.VwJadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VwJadwalRepository extends JpaRepository<VwJadwal,Long> {
}
