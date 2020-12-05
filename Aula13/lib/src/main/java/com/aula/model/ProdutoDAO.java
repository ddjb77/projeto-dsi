package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO{
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Produto prod) {
        String sql = "INSERT INTO produto " +
    "(nome,preco) VALUES (?,?)" ;
        jdbc.update(sql, new Object[]{
        		prod.getNome(), prod.getPreco()
        });
    }
    
    public Map<String, Object> getProduto(int id) {
    	String sql = "SELECT * FROM produto WHERE produto.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getProdutos() {
    	String sql = "SELECT * FROM produto";
    	List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return produtos;
    }
    
    public void deleteProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateProduto(int id,Produto prod) {
    	String sql = "UPDATE produto SET nome = ?, preco = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		prod.getNome(), prod.getPreco(),id
         });
    }
}
