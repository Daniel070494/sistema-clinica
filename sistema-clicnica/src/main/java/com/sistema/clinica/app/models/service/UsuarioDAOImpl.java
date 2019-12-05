package com.sistema.clinica.app.models.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.sistema.clinica.app.models.dao.UsuarioDAO;
import com.sistema.clinica.app.models.entity.Usuario;

@Service("usuarioDAOImpl")
public class UsuarioDAOImpl implements UsuarioDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario getUsuarios() {
		StringBuffer sql = new StringBuffer();
		Usuario user = new Usuario();
		
		sql.append(" SELECT med_n, cedula_pro, genero, email, concat(nombre, ' ', a_paterno, ' ', a_materno) as nombre FROM medicos ");
		
		try {
		
		user = (Usuario) jdbcTemplate.queryForObject(sql.toString(), new UsuarioMapper());
		
		}catch(DataAccessException e){
			System.out.println("Error query usuarios: " +  e.toString());
		}
		
		return user;
	}
	
	  @SuppressWarnings("rawtypes")
	  private class UsuarioMapper implements RowMapper {
	    public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	Usuario dto = new Usuario();
	    	
	    	dto.setNombre(rs.getString("nombre"));
	    	
	    	return dto;
	    }
	  }
}
