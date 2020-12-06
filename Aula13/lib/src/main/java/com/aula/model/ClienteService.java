package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	  @Autowired 
	  ClienteDAO cli;
	  
	  public void insert(Cliente cliente) {
	    cli.insert(cliente);
	  }
	  
	  public Map<String, Object> getCliente(int id) {
		  return cli.getCliente(id);
	  }
	  
	  public List<Map<String, Object>> getClientes() {
	      return cli.getClientes();
	  }
	  
	  public void deleteCliente(int id) {
		  cli.deleteCliente(id);
	  }
	  
	  public void updateCliente(int id, Cliente cliente) {
		  cli.updateCliente(id, cliente);
	  }
}