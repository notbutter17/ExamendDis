package com.cmm.jgtmsmatricula.Service;



import com.cmm.jgtmsmatricula.Dtos.MatriculaDto;
import com.cmm.jgtmsmatricula.Models.Matricula;

import java.util.List;

public interface MatriculaService {
    Matricula save(Matricula matricula);
    Matricula update(Long id, Matricula matricula);
    void delete(Long id);
    MatriculaDto findById(Long id);
    List<Matricula> findAll();
}