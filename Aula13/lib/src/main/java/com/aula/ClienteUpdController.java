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
	
	@GetMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		ClienteService cli = context.getBean(ClienteService.class);
		Map<String,Object> older = cli.getCliente(id);
		Cliente c = new Cliente((int)older.get("id"),(String)older.get("nome"),(String)older.get("endereco"),(String)older.get("tel"),(String)older.get("email"));
		model.addAttribute("older",c);
		model.addAttribute("id",id);
		return "formclienteupd";
    }
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Cliente c, Model model) {
		ClienteService cli = context.getBean(ClienteService.class);
		cli.updateCliente(id, c);
		return "redirect:/clientes";
	}
}