package com.example.ForoHUB.domain.Topicos;

import com.example.ForoHUB.domain.Cursos.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String message,

        @NotNull @Valid
        Curso curso) {
}
