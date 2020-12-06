package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO{
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Cliente cliente) {
        String sql = "INSERT INTO cliente " +
    "(nome,tel,endereco,email) VALUES (?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
        		cliente.getNome(), cliente.getTel(), cliente.getEndereco(), cliente.getEmail()
        });
    }
    
    public Map<String, Object> getcliente(int id) {
    	String sql = "SELECT * FROM cliente WHERE cliente.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getclientes() {
    	String sql = "SELECT * FROM cliente";
    	List<Map<String, Object>> clientes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return clientes;
    }
    
    public void deletecliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updatecliente(int id,cliente cliente) {
    	String sql = "UPDATE cliente SET nome = ?, tel = ?, endereco = ? email = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		cliente.getNome(), cliente.getTel(), cliente.getEndereco(), cliente.getEmail()id
         });
    }
}
