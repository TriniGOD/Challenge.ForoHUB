package com.example.ForoHUB.controller;

import com.example.ForoHUB.domain.Topicos.*;
import com.example.ForoHUB.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopicos(
            @RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
            UriComponentsBuilder uriComponentsBuilder){
        if(topicoRepository != null){
            if(topicoRepository.existsByTituloAndMessage(datosRegistroTopico.titulo(), datosRegistroTopico.message())){
                return ResponseEntity.badRequest().build();
            }
        }
        System.out.println(datosRegistroTopico);
        Topico topico = new Topico(datosRegistroTopico);
        System.out.println(topico);
        topicoRepository.save(topico);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMessage(),
                topico.getFecha(),
                topico.getCurso(),
                topico.getAutor()
        );
        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 3) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        //if(!Objects.equals(id, datosActualizarTopico.id())) return ResponseEntity.badRequest().build();
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if(topicoBuscado.isPresent()){
            Topico topico = topicoRepository.getReferenceById(id);
            topico.actualizarTopico(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(
                            topico.getId(),
                            topico.getTitulo(),
                            topico.getMessage(),
                            topico.getFecha(),
                            topico.getCurso(),
                            topico.getAutor()
                    )
            );
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornarTopicoEspecifico(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if(topicoBuscado.isPresent()){
            Topico topico = topicoRepository.getReferenceById(id);
            return ResponseEntity.ok(new DatosRespuestaTopico(
                            topico.getId(),
                            topico.getTitulo(),
                            topico.getMessage(),
                            topico.getFecha(),
                            topico.getCurso(),
                            topico.getAutor()
                    )
            );
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarMedico(@PathVariable Long id){
        Optional<Topico> topicoBuscado = topicoRepository.findById(id);
        if(topicoBuscado.isPresent()){
            Topico topico = topicoRepository.getReferenceById(id);
            topico.desactivarMedico();
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    //DELETE DB
    /*public void eliminarMedico(@PathVariable Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        medicoRepository.delete(medico);
    }*/

}
