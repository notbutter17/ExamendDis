package com.cmm.jgtmsmatricula.Service.ServiceImpl;


import com.cmm.jgtmsmatricula.Models.DetalleMatricula;
import com.cmm.jgtmsmatricula.Repository.DetalleMatriculaRepository;
import com.cmm.jgtmsmatricula.Service.DetalleMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {

    private final DetalleMatriculaRepository repository;

    @Override
    public List<DetalleMatricula> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<DetalleMatricula> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetalleMatricula guardar(DetalleMatricula detalle) {
        return repository.save(detalle);
    }

    @Override
    public DetalleMatricula actualizar(Long id, DetalleMatricula detalle) {
        detalle.setIdDetalleMatricula(id);
        return repository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}