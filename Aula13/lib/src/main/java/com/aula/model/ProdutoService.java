package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	  @Autowired 
	  ProdutoDAO pdao;
	  
	  public void insert(Produto prod) {
	    pdao.insert(prod);
	  }
	  
	  public Map<String, Object> getProduto(int id) {
		  return pdao.getProduto(id);
	  }
	  
	  public List<Map<String, Object>> getProdutos() {
	      return pdao.getProdutos();
	  }
	  
	  public void deleteProduto(int id) {
		  pdao.deleteProduto(id);
	  }
	  
	  public void updateProduto(int id, Produto prod) {
		  pdao.updateProduto(id, prod);
	  }
}