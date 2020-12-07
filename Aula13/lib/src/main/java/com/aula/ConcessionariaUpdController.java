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

import com.aula.model.Concessionaria;
import com.aula.model.ConcessionariaService;
@Controller
public class ConcessionariaUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updatecon/{id}")
    public String updateForm(@PathVariable("id") int id, Model model){
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		Map<String,Object> old = concdao.getConcessionaria(id);
		Concessionaria con = new Concessionaria((int)old.get("id"),(String)old.get("nome"),(String)old.get("endereco"),(String)old.get("tel"),(String)old.get("email"),(String)old.get("nome_veiculo"),(float)old.get("preco_veiculo"));
		model.addAttribute("old",con);
		model.addAttribute("id",id);
		return "concupdate";
	}
	
	@PostMapping("/updatecon/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute Concessionaria con, Model model) {
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		concdao.updateConcessionaria(id, con);
		return "redirect:/concessionarias";
	}
}