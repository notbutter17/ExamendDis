package com.cmm.jgtmsmatricula.Controller;



import com.cmm.jgtmsmatricula.Dtos.MatriculaDto;
import com.cmm.jgtmsmatricula.Models.DetalleMatricula;
import com.cmm.jgtmsmatricula.Models.Matricula;
import com.cmm.jgtmsmatricula.Service.DetalleMatriculaService;
import com.cmm.jgtmsmatricula.Service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final DetalleMatriculaService detalleMatriculaService;

    @Autowired
    public MatriculaController(MatriculaService matriculaService, DetalleMatriculaService detalleMatriculaService) {
        this.matriculaService = matriculaService;
        this.detalleMatriculaService = detalleMatriculaService;
    }

    // Crear matrícula
    @PostMapping
    public ResponseEntity<Matricula> create(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.save(matricula));
    }

    // Actualizar matrícula
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> update(@PathVariable Long id, @RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.update(id, matricula));
    }

    // Eliminar matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar matrícula por ID (con cursos incluidos)
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDto> getById(@PathVariable Long id) {
        MatriculaDto matriculaDTO = matriculaService.findById(id);
        return ResponseEntity.ok(matriculaDTO);
    }
    @PostMapping("/{id}/detalles")
    public ResponseEntity<DetalleMatricula> addDetalle(
            @PathVariable Long id,
            @RequestBody DetalleMatricula detalle
    ) {
        // Asociar matrícula al detalle
        Matricula matricula = new Matricula();
        matricula.setIdMatricula(id);
        detalle.setMatricula(matricula);

        DetalleMatricula saved = detalleMatriculaService.guardar(detalle);
        return ResponseEntity.ok(saved);
    }

    // Listar todas las matrículas
    @GetMapping
    public ResponseEntity<List<Matricula>> getAll() {
        return ResponseEntity.ok(matriculaService.findAll());
    }
}
