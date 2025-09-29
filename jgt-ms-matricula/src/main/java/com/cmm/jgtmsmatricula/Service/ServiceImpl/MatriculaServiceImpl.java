package com.cmm.jgtmsmatricula.Service.ServiceImpl;


import com.cmm.jgtmsmatricula.Dtos.CursoDto;
import com.cmm.jgtmsmatricula.Dtos.DetalleMatriculaDto;
import com.cmm.jgtmsmatricula.Dtos.MatriculaDto;
import com.cmm.jgtmsmatricula.Feign.CursoFeign;
import com.cmm.jgtmsmatricula.Models.DetalleMatricula;
import com.cmm.jgtmsmatricula.Models.Matricula;
import com.cmm.jgtmsmatricula.Repository.DetalleMatriculaRepository;
import com.cmm.jgtmsmatricula.Repository.MatriculaRepository;
import com.cmm.jgtmsmatricula.Service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final DetalleMatriculaRepository detalleMatriculaRepository;
    private final CursoFeign cursoFeign;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, DetalleMatriculaRepository detalleMatriculaRepository, CursoFeign cursoFeign) {
        this.matriculaRepository = matriculaRepository;
        this.detalleMatriculaRepository = detalleMatriculaRepository;
        this.cursoFeign = cursoFeign;
    }

    @Override
    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Long id, Matricula matricula) {
        return matriculaRepository.save(matricula);

    }

    @Override
    public void delete(Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar, matrícula con id " + id + " no existe");
        }
    }

    @Override
    public MatriculaDto findById(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula con id " + id + " no encontrada"));

        // Obtener detalles de la matrícula
        List<DetalleMatricula> detalles = detalleMatriculaRepository.findByMatriculaIdMatricula(id);

        List<DetalleMatriculaDto> detallesDTO = detalles.stream().map(det -> {
            DetalleMatriculaDto dto = new DetalleMatriculaDto();
            dto.setIdDetalleMatricula(det.getIdDetalleMatricula());
            dto.setIdCurso(det.getIdCurso()); // <-- más claro
            dto.setIdMatricula(det.getMatricula().getIdMatricula());

            CursoDto curso = cursoFeign.buscarPorId(det.getIdCurso()).getBody();
            dto.setCurso(curso);

            return dto;
        }).toList();

        // Construir DTO de matrícula
        MatriculaDto dto = new MatriculaDto();
        dto.setIdMatricula(matricula.getIdMatricula());
        dto.setNumeroMatricula("Matrícula " + matricula.getNumeroMatricula());
        dto.setNombreAlumno(matricula.getNombreAlumno());// puedes personalizar
        dto.setDetalles(detallesDTO);

        return dto;
    }

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }
}