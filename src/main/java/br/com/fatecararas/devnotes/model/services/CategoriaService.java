package br.com.fatecararas.devnotes.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.entities.Categoria;
import br.com.fatecararas.devnotes.model.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public List<CategoriaDTO> buscarTodas() {
        return repository.findAll()
                .stream()
                .map(c -> CategoriaDTO
                        .builder()
                        .id(c.getId())
                        .descricao(c.getDescricao())
                        .build())
                .collect(Collectors.toList());
    }
}
