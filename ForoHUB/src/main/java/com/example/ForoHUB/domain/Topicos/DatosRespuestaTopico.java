package com.example.ForoHUB.domain.Topicos;

import com.example.ForoHUB.domain.Cursos.Curso;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String message,
        LocalDateTime fecha,
        Curso curso,
        String autor
) {

}
