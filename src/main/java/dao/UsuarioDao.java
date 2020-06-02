package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsuarioDao {

	public boolean incluir (Usuario usuario) {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			
			pst = conexao.prepareStatement("insert into usuario (email) values (?) ");
			pst.setString(1,usuario.getEmail());
			pst.execute();
			pst.close();
			conexao.close();
			return true;
		} catch (SQLException e ) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
				
		
		
	}
	//listar r do nosso GRUD
	
	public List<Usuario> listar() {
		Connection conexao = Conexao.getConectar();
		PreparedStatement pst;
		try {
			pst = conexao.prepareStatement("select * from usuario");
			ResultSet rs = pst.executeQuery();
			
			List<Usuario> lsUsuario = new ArrayList<Usuario>();
			
			
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setEmail(rs.getString("email"));
				lsUsuario.add(u);
				
			}
			return lsUsuario;	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
