

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
		private static final String url="jdbc:mysql://localhost:3306/RAKU_TEST";
		private static final String driver="com.mysql.jdbc.Driver";
		private static final String username="bbloggsbott";
		private static final String password="suju@7975";
		public DBUtil(){}
		public static Connection getConnection(){
			Connection con = null;
			try{
				Class.forName(driver);
				con=DriverManager.getConnection(url, username, password);
			}catch(ClassNotFoundException | SQLException e){
				System.out.println(e.getMessage());
			}
			return con;
		}
		public static void closeAll(Connection con,PreparedStatement pst,ResultSet rs) throws SQLException{
			if(rs!=null){
			rs.close();
			}
			con.close();
			pst.close();
		}
}