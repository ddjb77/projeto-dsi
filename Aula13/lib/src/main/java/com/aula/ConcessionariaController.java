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

import com.aula.model.Concessionaria;
import com.aula.model.ConcessionariaService;

@Controller
public class ConcessionariaController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/concessionaria")
	public String cadastrar(Model model) {
		model.addAttribute("con",new Concessionaria());
		return "formconcessionaria";
	}
	
	@PostMapping("/concessionaria")
	public String acao(@ModelAttribute Concessionaria con,Model model) {
		model.addAttribute("con",con);
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		concdao.insert(con);
		return "concsucesso";
	}
	
	@GetMapping("concinf/{id}")
    public String read(@PathVariable("id") int id, Model model){
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		Map<String,Object> Concessionaria = concdao.getConcessionaria(id);
		Concessionaria con = new Concessionaria((int)Concessionaria.get("id"),(String)Concessionaria.get("nome"),(String)Concessionaria.get("endereco"),(String)Concessionaria.get("tel"),(String)Concessionaria.get("email"), (String)Concessionaria.get("nome_veiculo"), (double) Concessionaria.get("preco_veiculo"));
		model.addAttribute("con",con);
		return "concsucesso";
    }

	@GetMapping("/concessionarias")
	public String listar(Model model) {
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		List<Map<String,Object>> concessionarias = concdao.getConcessionarias();
		model.addAttribute("concessionarias",concessionarias);
		return "formlistacon";
	}
	
	@PostMapping("/deletecon/{id}")
	public String deletar(@PathVariable("id") int id,Model model) {
		ConcessionariaService concdao = context.getBean(ConcessionariaService.class);
		concdao.deleteConcessionaria(id);
		return "redirect:/concessionarias";
	}

}
