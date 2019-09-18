package br.com.fiap.olamundo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "produto/form";
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(Produto produto, Model model){
        model.addAttribute("prod", produto);
        return "produto/sucesso";
    }
}