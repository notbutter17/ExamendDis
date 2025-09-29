package com.cmm.jgtmscurso.Repository;


import com.cmm.jgtmscurso.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {


}