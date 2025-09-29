package com.cmm.jgtmscurso.Service;


import com.cmm.jgtmscurso.Model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();

    Curso guardar(Curso curso);
    Curso buscarPorId(Long id); // ← agregado

    Curso actualizar(Curso persona);
    Optional<Curso> listarPorId(Long id);
    void eliminarPorId(Long id);

}
