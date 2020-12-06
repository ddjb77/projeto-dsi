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

import com.aula.model.Cliente;
import com.aula.model.ClienteService;
@Controller
public class ClienteUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		ClienteService cli = context.getBean(ClienteService.class);
		Map<String,Object> antigo = cli.getCliente(id);
		Cliente cliente = new Cliente((int)antigo.get("id"),(String)antigo.get("nome"),(String)antigo.get("endereco"),(String)antigo.get("tel"),(String)antigo.get("email"));
		model.addAttribute("antigo",cliente);
		model.addAttribute("id",id);
		return "formclienteupd";
    }
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Cliente cliente, Model model) {
		ClienteService cli = context.getBean(ClienteService.class);
		cli.updateCliente(id, cliente);
		return "redirect:/Clientes";
	}
}