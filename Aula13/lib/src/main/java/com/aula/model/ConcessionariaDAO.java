package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConcessionariaDAO{
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    public void insert(Concessionaria con) {
        String sql = "INSERT INTO concessionaria (nome,endereco,tel,email,nome_veiculo,preco_veiculo) VALUES (?,?,?,?,?,?)" ;
        jdbc.update(sql, new Object[]{
        		con.getNome(),con.getEndereco(),con.getTel(),con.getEmail(), con.getNome_veiculo(), con.getPreco_veiculo()
        });
    }
    
    public Map<String, Object> getConcessionaria(int id) {
    	String sql = "SELECT * FROM concessionaria WHERE concessionaria.id = ?";
    	return jdbc.queryForMap(sql,new Object[] {id});
    }
    
    public List<Map<String, Object>> getConcessionarias() {
    	String sql = "SELECT * FROM concessionaria";
    	List<Map<String, Object>> concessionarias = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return concessionarias;
    }
    
    public void deleteConcessionaria(int id) {
        String sql = "DELETE FROM concessionaria WHERE id = ?" ;
        jdbc.update(sql, new Object[] {id});
    }
    
    public void updateConcessionaria(int id, Concessionaria con) {
    	String sql = "UPDATE concessionaria SET nome = ?, endereco = ?, tel = ?,  email = ?, nome_veiculo = ?, preco_veiculo = ? WHERE id = ?";
    	 jdbc.update(sql, new Object[]{
         		con.getNome(),con.getEndereco(),con.getTel() ,con.getEmail(),con.getNome_veiculo(), con.getPreco_veiculo(), id
         });
    }
}
