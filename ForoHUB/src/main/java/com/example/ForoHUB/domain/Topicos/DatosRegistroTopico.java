package com.example.ForoHUB.domain.Topicos;

import com.example.ForoHUB.domain.Cursos.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String message,
        @NotNull @Valid
        Curso curso,
        @NotBlank
        String autor
    ) {
}
