package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.VwNota;
import com.binaracademy.Challange4.Entity.VwNotaPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface VwNotaRepository extends JpaRepository<VwNota, VwNotaPk> {
    List<VwNota> findByIdNota(Long user);
}
