package br.com.fatecararas.devnotes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.entities.Nota;
import br.com.fatecararas.devnotes.model.services.CategoriaService;
import br.com.fatecararas.devnotes.model.services.NotaService;

@Controller
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private NotaService service;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String notas() {
        return "notas/listar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Nota nota) {
        return "notas/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Nota nota) {
        service.salvar(nota);
        return "redirect:/notas";
    }

    //TODO: Criar os recursos para edição e exclusão da notas
    // Inclusão dos objetos necessários para a listagem e cadastro de notas
    @ModelAttribute(name = "notas")
    public List<Nota> getNotas() {
        return service.findAll();
    }

    @ModelAttribute(name = "categorias")
    public List<CategoriaDTO> getCategorias() {
        return categoriaService.buscarTodas();
    }
}
