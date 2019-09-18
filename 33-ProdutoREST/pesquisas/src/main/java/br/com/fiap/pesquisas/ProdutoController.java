package br.com.fiap.pesquisas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "produto/form";
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(Produto produto, Model model){
        repository.save(produto);
        model.addAttribute("prod", produto);
        return "produto/sucesso";
    }
}
