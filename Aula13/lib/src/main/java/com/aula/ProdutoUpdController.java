package com.aula;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.model.Produto;
import com.aula.model.ProdutoService;
@Controller
public class ProdutoUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		ProdutoService pdao = context.getBean(ProdutoService.class);
		Map<String,Object> antigo = pdao.getProduto(id);
		Produto prod = new Produto((String)antigo.get("nome"),(float)antigo.get("preco"));
		model.addAttribute("antigo",prod);
		model.addAttribute("id",id);
		return "formprodupd";
    }
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Produto prod, Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.updateProduto(id, prod);
		return "redirect:/produtos";
	}
}
