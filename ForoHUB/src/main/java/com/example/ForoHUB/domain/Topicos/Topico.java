package com.example.ForoHUB.domain.Topicos;

import com.example.ForoHUB.domain.Cursos.Curso;
import com.example.ForoHUB.domain.Usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "Id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String message;
    @CreationTimestamp
    private LocalDateTime fecha;
    private boolean status;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.message = datosRegistroTopico.message();
        this.fecha = LocalDateTime.now();
        this.curso = datosRegistroTopico.curso();
        this.autor = datosRegistroTopico.autor();
        this.status = true;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", message='" + message + '\'' +
                ", fecha=" + fecha +
                ", status=" + status +
                ", autor='" + autor + '\'' +
                ", curso=" + curso +
                '}';
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico){
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.message() != null){
            this.message = datosActualizarTopico.message();
        }

        if(datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
    }

    public void desactivarMedico(){
        this.status = false;
    }

}
