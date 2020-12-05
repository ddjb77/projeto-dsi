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

import com.aula.model.Cliente;
import com.aula.model.ClienteService;

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
	public String acao(@ModelAttribute Cliente cliente,Model model) {
		model.addAttribute("cliente",cliente);
		ClienteService cli = context.getBean(ClienteService.class);
		cli.insert(cliente);
		return "clientesucesso";
	}
	
	@GetMapping("descr/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ClienteService cli = context.getBean(ClienteService.class);
		Map<String,Object> cliente = cli.getCliente(id);
		Cliente cli = new Cliente((String)cliente.get("nome"),cliente.get("tel"), cliente.get("email"), cliente.get("endereco"));
		model.addAttribute("cliente",cliente);
		return "clientessucesso";
    }
	
	@GetMapping("/cliente")
	public String listar(Model model) {
		ClienteService cli = context.getBean(ClienteService.class);
		List<Map<String,Object>> clientes = cli.getClientes();
		model.addAttribute("clientes",clientes);
		return "formlistacli";
	}
	
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ClienteService cli = context.getBean(ClienteService.class);
		cli.deleteCliente(id);
		return "redirect:/clientes";
	}
	

}