package com.cmm.jgtmsmatricula.Feign;

import com.cmm.jgtmsmatricula.Dtos.CursoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "jgt-ms-curso-service", path = "/cursos")
public interface CursoFeign {

    @GetMapping("/{id}")
    ResponseEntity<CursoDto> buscarPorId(@PathVariable Long id);

}