package com.cmm.jgtmsmatricula.Repository;

import com.cmm.jgtmsmatricula.Models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}