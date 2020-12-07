package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcessionariaService {
	  @Autowired 
	  ConcessionariaDAO concdao;
	  
	  public void insert(Concessionaria con) {
	    concdao.insert(con);
	  }
	  
	  public Map<String, Object> getConcessionaria(int id) {
		  return concdao.getConcessionaria(id);
	  }
	  
	  public List<Map<String, Object>> getConcessionarias() {
	      return concdao.getConcessionarias();
	  }
	  
	  public void deleteConcessionaria(int id) {
		  concdao.deleteConcessionaria(id);
	  }
	  
	  public void updateConcessionaria(int id, Concessionaria con) {
		  concdao.updateConcessionaria(id, con);
	  }
}