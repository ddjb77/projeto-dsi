package com.aula;

import java.util.List;
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
public class ClienteController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/cliente")
	public String cadastrar(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "formcliente";
	}
	
	@PostMapping("/cliente")
	public String acao(@ModelAttribute Produto prod,Model model) {
		model.addAttribute("prod",prod);
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.insert(prod);
		return "produtosucesso";
	}
	
	@GetMapping("descr/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ProdutoService pdao = context.getBean(ProdutoService.class);
		Map<String,Object> produto = pdao.getProduto(id);
		Produto prod = new Produto((String)produto.get("nome"),(double)produto.get("preco"));
		model.addAttribute("prod",prod);
		return "produtosucesso";
    }
	
	@GetMapping("/produtos")
	public String listar(Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produtos",produtos);
		return "formlista";
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.deleteProduto(id);
		return "redirect:/produtos";
	}
	

}