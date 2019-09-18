package br.com.fiap.olamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    @GetMapping("/produto/cadastrar")
    public String abrirFormulario(){
        return "produto/form";
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(String nome, double preco){
        System.out.print(nome + " " + preco);
        return "produto/sucesso";
    }
}