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
    
    public void insert(Cliente c) {
        String sql = "INSERT INTO cliente " +
    "(nome,endereco,tel,email) VALUES (?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
        		c.getNome(), c.getTel(), c.getEndereco(), c.getEmail()
        });
    }
    
    public Map<String, Object> getCliente(int id) {
    	String sql = "SELECT * FROM cliente WHERE cliente.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getClientes() {
    	String sql = "SELECT * FROM cliente";
    	List<Map<String, Object>> clientes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return clientes;
    }
    
    public void deleteCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateCliente(int id, Cliente c) {
    	String sql = "UPDATE cliente SET nome = ?, endereco = ?, tel = ?,  email = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		c.getNome(), c.getEndereco(), c.getTel() , c.getEmail(), id
         });
    }
}
