package br.com.fatecararas.devnotes.api.resources;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.devnotes.model.entities.Nota;
import br.com.fatecararas.devnotes.model.repositories.NotaRepository;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/v1/notas")
public class NotasResource {

    private final NotaRepository repository;
    //TODO: Criar os métodos para o gerenciamento de Notas via REST
    @GetMapping
    public List<Nota> findAll() {
        return repository.findAll();
    }

    // Create delete note
    @DeleteMapping
    public void delete(Nota nota) {
        repository.delete(nota);
    }
}
