package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.VwNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface VwNotaRepository extends JpaRepository<VwNota,Long> {
}
