package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ajuda.Conexao;

public class UsuariosDAO extends Usuario {

	public static void criar(Usuario usuario) {
		
		String sql = "INSERT INTO usuarios(nome, telefone, cpf, email, senha)" + "VALUES (?,?,?,?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getTelefone());
			pstm.setString(3, usuario.getCpf());
			pstm.setString(4, usuario.getEmail());
			pstm.setString(5, usuario.getSenha());

			pstm.execute();

			System.out.println("Criado com sucesso no mysql!");

		} catch (Exception e) {
			// e.printStackTrace();  getMessage() é o resumo do erro
			System.out.println("Erro ao cadastrar usuario: " + e.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	public static void deletar(String cpf) {
		String sql = "DELETE FROM usuarios WHERE cpf = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);

			pstm.execute();
			System.out.println("Deletado com sucesso!");

		} catch (Exception e) {
			//e.printStackTrace(); getMessage() é o resumo do erro
			System.out.println("Erro ao deletar usuario: " + e.getMessage());
		} finally {

			try {

				if (pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
	}

	public static void atualizar(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?, telefone = ? WHERE cpf = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getTelefone());
			pstm.setString(5, usuario.getCpf());

			pstm.execute();

			System.out.println("Atualizado com sucesso!");

		} catch (Exception e) {
			

		} finally {

			try {

				if (pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}
	
	public static Usuario buscarUsuario(String cpfBuscado) {
		// poderia criar o comando sql já com o cpf direto concatenado na string
		//String sql = "SELECT * FROM usuarios WHERE cpf = "+cpf;
		
		String sql = "SELECT * FROM usuarios WHERE cpf = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpfBuscado);

			rset = pstm.executeQuery();
			
			rset.next();
			
			int id = rset.getInt("id");
			String nome = rset.getString("nome");
			String email = rset.getString("email");
			String cpf = rset.getString("cpf");
			String senha = rset.getString("senha");
			String telefone = rset.getString("telefone");
			
			//criando um objeto com os dados encontrados na tabela
			Usuario usuario = new Usuario(id, nome, email, cpf, senha, telefone);

			// imprimir na tela o objeto encontrado
			// System.out.println(usuario.toString());
			return usuario;

		} catch (Exception e) {
			//e.printStackTrace(); getMessage() é o resumo do erro
			System.out.println("Erro ao buscar usuario: " + e.getMessage());

		} finally {

			try {

				if (pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

		}
		
		
		
		
		return null;
		
	}

	
	
	
	
	
	public static List<Usuario> getUser() {
		String sql = "SELECT * FROM usuarios";
		List<Usuario> usuarios = new ArrayList<Usuario>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Usuario usuario = new Usuario();

				usuario.setId(rset.getInt("id_Usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setCpf(rset.getString("cpf_unico"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setTelefone(rset.getString("telefone"));
				usuarios.add(usuario);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (pstm != null) {

					pstm.close();

				}

				if (conn != null) {

					conn.close();

				}

				if (rset != null) {

					rset.close();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return usuarios;

	}
}
