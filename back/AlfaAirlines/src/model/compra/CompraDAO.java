package model.compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ajuda.Conexao;
import model.pacote.Pacote;
import model.usuario.Usuario;

public class CompraDAO {

	public static void criar(Compra compra) {
		String sql = "INSERT INTO compras(id_usuario, id_pacote) VALUES (?,?)";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getUsuario().getId());
			pstm.setInt(2, compra.getPacote().getId());

			pstm.execute();

			System.out.println("Compra criada com sucesso no mysql!");

		} catch (Exception e) {
			// e.printStackTrace(); getMessage() é o resumo do erro
			System.out.println("Erro ao comprar: " + e.getMessage());
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

	public static void listarPorUsuario(Usuario usuario) {
		String sql = "SELECT compra.id, usuario.cpf, pacote.origem, pacote.destino "
				+ "FROM compras compra "
				+ "JOIN usuarios usuario ON compra.id_usuario = usuario.id "
				+ "JOIN pacotes pacote ON compra.id_pacote = pacote.id "
				+ "WHERE usuario.cpf = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Compra compra = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usuario.getCpf());
			rs = pstm.executeQuery();

			while (rs.next()) {
				int idCompra = rs.getInt("id");
				String cpf = rs.getString("cpf");
				String origem = rs.getString("origem");
				String destino = rs.getString("destino");
				
				System.out.println("|ID: "+ idCompra + " |CPF: " + cpf + " |Origem: " + origem + " |Destino: " + destino + "|");
			}

		} catch (Exception e) {
			System.out.println("Erro ao recuperar compra: " + e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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

	public static void atualizar(Compra compra) {
		String sql = "UPDATE compra SET id_usuario = ?, id_pacote = ? WHERE id_compra = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getUsuario().getId());
			pstm.setInt(2, compra.getPacote().getId());
			pstm.setInt(3, compra.getId());

			pstm.executeUpdate();

			System.out.println("Compra atualizada com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao atualizar compra: " + e.getMessage());
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

	public static void excluir(int idCompra) {
		String sql = "DELETE FROM compras WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCompra);
			pstm.executeUpdate();

			System.out.println("Compra excluída com sucesso!");

		} catch (Exception e) {
			System.out.println("Erro ao excluir compra: " + e.getMessage());
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
}
