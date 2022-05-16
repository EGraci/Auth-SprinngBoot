package com.binaracademy.Challange4.Repository;

import com.binaracademy.Challange4.Entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NotaRepository extends JpaRepository<Nota, Long> {
}
