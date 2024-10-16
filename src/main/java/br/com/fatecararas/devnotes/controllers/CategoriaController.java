package br.com.fatecararas.devnotes.controllers;

import java.util.List;

import br.com.fatecararas.devnotes.model.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;
    
    @GetMapping
    public String categorias(Model model) {
        List<CategoriaDTO> categorias = service.buscarTodas();
        model.addAttribute("categorias", categorias);
        return "listar";
    }

    @GetMapping("/cadastrar")
    public String criar(Categoria categoria) {
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(Categoria categoria) {
        service.salvar(categoria);
        return "redirect:/categorias";
    }
}
