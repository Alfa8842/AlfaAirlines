package ajuda;

import java.sql.Connection;
import java.sql.DriverManager;

 

public class Conexao {

	

	private static final String USERNAME = "root";

	private static final String PASSWORD = "Alfa@8842";

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/AlfaAirlines";


	public static Connection createConnectionToMysql() throws Exception{
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		 return connection;
		}

}