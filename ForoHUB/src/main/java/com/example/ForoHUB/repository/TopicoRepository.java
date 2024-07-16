package com.example.ForoHUB.repository;

import com.example.ForoHUB.domain.Topicos.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByStatusTrue(Pageable paginacion);

    Optional<Topico> findById(Long id);

    boolean existsByTituloAndMessage(String titulo, String mensaje);
}
