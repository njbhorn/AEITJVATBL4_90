import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProgramMySQL {

	public static void main(String[] args) {

		String connectionUrl = "jdbc:mysql://localhost/theatre?" ;
		connectionUrl += "user=root&password=Pa$$w0rd" ;

		try {
			Connection connection = DriverManager.getConnection(connectionUrl);
			String sql = "select * from performer" ;

			Statement statement = connection.createStatement() ;
			ResultSet resultSet = statement.executeQuery(sql);

			int id, height ;
			String fname, sname ;
			StringBuilder out = new StringBuilder() ;
			while ( resultSet.next() ){
				id = resultSet.getInt("MembershipID");
				fname = resultSet.getString(2) ;
				sname = resultSet.getString(3) ;
				height = resultSet.getInt(4);
				out.append("Member Id : ");
				out.append (id) ;
				out.append(" Name : ");
				out.append(fname) ;
				out.append(" ");
				out.append(sname);
				out.append(" Height : ");
				out.append(height);
				out.append("cms");
				out.append("\n");
			}
			System.out.println(out.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

}
