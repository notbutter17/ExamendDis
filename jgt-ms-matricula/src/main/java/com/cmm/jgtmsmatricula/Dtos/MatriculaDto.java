package com.cmm.jgtmsmatricula.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatriculaDto {
    private Long idMatricula;
    private String nombreAlumno;
    private String numeroMatricula;
    private List<DetalleMatriculaDto> detalles;
}