package com.example.ForoHUB.domain.Topicos;

import com.example.ForoHUB.domain.Cursos.Curso;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String message,
        Curso curso
) {
    public DatosListadoTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMessage(), topico.getCurso());
    }
}
