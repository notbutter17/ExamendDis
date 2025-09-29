package com.cmm.jgtmscurso.Service.ServiceImpl;


import com.cmm.jgtmscurso.Model.Curso;
import com.cmm.jgtmscurso.Repository.CursoRepository;
import com.cmm.jgtmscurso.Service.CursoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository repository;
    @Override
    public List<Curso> listar() {
        return repository.findAll();
    }
    @Override
    public Curso buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrada con id: " + id));
    }
    @Override
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public Curso actualizar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public Optional<Curso> listarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);

    }
}