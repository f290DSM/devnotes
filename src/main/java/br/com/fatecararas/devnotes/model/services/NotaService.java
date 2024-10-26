package br.com.fatecararas.devnotes.model.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.devnotes.model.entities.Nota;
import br.com.fatecararas.devnotes.model.repositories.NotaRepository;

@Service
public class NotaService {
    
    @Autowired
    private NotaRepository repository;

    public List<Nota> findAll() {
        return repository.findAll();
    }

    public void salvar(Nota nota) {
        repository.save(nota);
    }
}
