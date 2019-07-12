import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {

		String connectionUrl = "jdbc:sqlserver://INSTRUCTOR\\SQLEXPRESS:1433" ;
		connectionUrl += ";databaseName=Demo" ;
		connectionUrl += ";integratedSecurity=true";
		System.out.println(connectionUrl);

		try {
			Connection connection = DriverManager.getConnection(connectionUrl);
			String sql = "select * from person" ;

			Statement statement = connection.createStatement() ;
			ResultSet resultSet = statement.executeQuery(sql);

			int id ;
			String name ;
			StringBuilder out = new StringBuilder() ;
			while ( resultSet.next() ){
				id = resultSet.getInt(1);
				name = resultSet.getString(2) ;
				out.append("Id : " + id + " Name : " + name + "\n");
			}
			System.out.println(out.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
