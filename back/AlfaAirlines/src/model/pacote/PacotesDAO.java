package model.pacote;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ajuda.Conexao;
import model.usuario.Usuario;

public class PacotesDAO{

	public static int criar(Pacote pacote) {
		String sql = "INSERT INTO pacotes(destino, preco, promocao, data, origem)" + "VALUES (?,?,?,?,?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
			try { 
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				
				pstm.setString(1, pacote.getDestinos());
				pstm.setDouble(2, pacote.getPreco());
				pstm.setBoolean(3, pacote.getPromocao());
				pstm.setDate(4, pacote.getData());
				pstm.setString(5, pacote.getOrigem());
				
				pstm.execute();
				
				
				
				int idGerado = -1;
				
				rset = pstm.getGeneratedKeys();
                if (rset.next()) {
                    idGerado = rset.getInt(1);
                }
                
                System.out.println("Criado com sucesso no SQL! Id do pacote: "+idGerado);
				return idGerado;
				
			} catch (Exception e) {
				// e.printStackTrace();  getMessage() é o resumo do erro
				System.out.println("Erro ao cadastrar pacote: " + e.getMessage());
				return -1;
			}finally {
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

	public static void deletar(int id) {
		String sql = "DELETE FROM pacotes WHERE id = ?";
			
		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);				
								
			pstm.execute();	
			System.out.println("Deletado com sucesso!");

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}finally {

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

	public static void atualizar(Pacote pacote) {
		String sql = "UPDATE pacotes SET preco = ?, promocao = ? WHERE id = ?";
		
			Connection conn = null;
			PreparedStatement pstm = null;
			
				try {
					conn = Conexao.createConnectionToMysql();
					pstm = conn.prepareStatement(sql);
					pstm.setDouble(1, pacote.getPreco());
					pstm.setBoolean(2, pacote.getPromocao());
					pstm.setInt(3, pacote.getId());	
					
					pstm.execute();

					

					System.out.println("Atualizado com sucesso!");		

				} catch (Exception e) {

					System.out.println(e.getMessage());

				}finally {

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
	
	public static List<Pacote> getAllPacotes(){		

		 

		String sql = "SELECT * FROM pacotes";		

 

		List<Pacote> pacotes = new ArrayList<Pacote>();		

 

		Connection conn = null;

		PreparedStatement pstm = null;

		ResultSet rset = null;

 

			try {

				conn = Conexao.createConnectionToMysql();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();				

 

				while (rset.next()) {

					Pacote pacote = new Pacote();			

					pacote.setId(rset.getInt("id_pacote"));
					pacote.setDestinos(rset.getString("destino"));
					pacote.setPreco(rset.getDouble("preco"));
					pacote.setPromocao(rset.getBoolean("promocao"));	
					pacote.setData(rset.getDate("data"));	
					pacote.setOrigem(rset.getString("origem"));	


					pacotes.add(pacote);				

				}					

 

			} catch (Exception e) {

				e.printStackTrace();

			}finally {

				try {

					if (pstm != null) {

						pstm.close();

					}

					if (conn != null) {

						conn.close();

					}			

					if(rset != null) {

						rset.close();

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

 

			return pacotes;

	}

	public static Pacote buscarPacote(int idPacote) {

	
		String sql = "SELECT * FROM pacotes WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPacote);

			rset = pstm.executeQuery();
			
			rset.next();
			
			int id = rset.getInt("id");
			String destino = rset.getString("destino");
			double preco = rset.getDouble("preco");
			boolean promocao = rset.getBoolean("promocao");
			Date data = rset.getDate("data");
			String origem = rset.getString("origem");
			
			//criando um objeto com os dados encontrados na tabela
			Pacote pacote = new Pacote(id,destino,preco,promocao,data,origem);

			// imprimir na tela o objeto encontrado
			// System.out.println(usuario.toString());
			return pacote;

		} catch (Exception e) {
			//e.printStackTrace(); getMessage() é o resumo do erro
			System.out.println("Erro ao buscar pacote: " + e.getMessage());

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
}
