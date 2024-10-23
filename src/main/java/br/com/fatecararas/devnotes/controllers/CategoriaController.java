package br.com.fatecararas.devnotes.controllers;

import java.util.List;

import br.com.fatecararas.devnotes.model.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PatchExchange;

import br.com.fatecararas.devnotes.controllers.dtos.CategoriaDTO;
import br.com.fatecararas.devnotes.model.services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public String categorias() {
        // List<CategoriaDTO> categorias = service.buscarTodas();
        // model.addAttribute("categorias", categorias);
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

    @PostMapping("/atualizar")
    public String atualizar(Categoria categoria) {
        try {
            service.atualizar(categoria);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/categorias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String preEdicao(@PathVariable("id") Long id, Model model) {
        try {
            Categoria categoria = service.buscarPorId(id);
            model.addAttribute("categoria", categoria);
            return "cadastrar";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/categorias";
    }

    @GetMapping("/soma/{a}/{b}")
    public String somaPathVariable(@PathVariable("a") Integer a,
            @PathVariable("b") Integer b) {
        Integer r = a + b;
        System.out.printf("A soma de %d e %d é %d.\n", a, b, r);
        return "listar";
    }

    @GetMapping("/soma")
    public String somaRequestParam(@RequestParam("a") Integer a,
            @RequestParam("b") Integer b) {
        Integer r = a + b;
        System.out.printf("A soma de %d e %d é %d.\n", a, b, r);
        return "listar";
    }

    @ModelAttribute
    public List<CategoriaDTO> getCategorias() {
        return service.buscarTodas();
    }
}
