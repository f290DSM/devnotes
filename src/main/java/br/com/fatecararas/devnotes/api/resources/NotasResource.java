package br.com.fatecararas.devnotes.api.resources;

import java.util.List;

import br.com.fatecararas.devnotes.api.dto.NotaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import br.com.fatecararas.devnotes.model.entities.Nota;
import br.com.fatecararas.devnotes.model.repositories.NotaRepository;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/v1/notas")
public class NotasResource {

    private final NotaRepository repository;
    private final ModelMapper mapper;

    //TODO: Criar os métodos para o gerenciamento de Notas via REST
    @GetMapping
    public List<NotaDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(n -> mapper.map(n, NotaDTO.class))
                .toList();
    }

    @PostMapping
    public Nota create(@RequestBody @Valid NotaDTO dto) {
        Nota nota = mapper.map(dto, Nota.class);
        return repository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
