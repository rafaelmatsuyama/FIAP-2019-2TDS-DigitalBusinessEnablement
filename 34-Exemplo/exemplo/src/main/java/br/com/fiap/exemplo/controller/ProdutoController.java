package br.com.fiap.exemplo.controller;

import br.com.fiap.exemplo.entity.Produto;
import br.com.fiap.exemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

    @GetMapping("cadastrar")
    public String abrirFormulario(Produto produto, Model model){
        model.addAttribute("prod", produto);
        return "produto/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Produto produto, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        repository.save(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("listar")
    public String listarProdutos(Model model){
        model.addAttribute("produtos", repository.findAll());
        return "produto/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prod",repository.findById(codigo));
        return "produto/form";
    }

    @PostMapping("excluir")
    public String excluir(int codigo, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg","Exterminado!");
        repository.deleteById(codigo);
        return "redirect:/produto/listar";
    }
}
