package br.com.fatecararas.devnotes.api.resources;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.entities.Categoria;
import br.com.fatecararas.devnotes.model.services.CategoriaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasResource {

    private final CategoriaService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<CategoriaDTO> findAll() {
        return service.buscarTodas();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/salvar")
    public CategoriaDTO salvar(@RequestBody CategoriaDTO dto) {
        Categoria categoria = service.salvar(mapper.map(dto, Categoria.class));
        return mapper.map(categoria, CategoriaDTO.class);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable("id") Long id) {
        service.excluir(id);
    }

    // TODO: Cria o método de alteração de categoria.

    // TODO: Cria o método de busca por ID de categoria.
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Categoria findById(@PathVariable("id") Long id) throws Exception{
        return service.buscarPorId(id);
    }
}
