import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao{

  //User Login
  public boolean login(String username, String password){
    boolean result = false;
    try{
      Connection cn=DBUtil.getConnection();
      PreparedStatement ps=cn.prepareStatement("SELECT * FROM USERS WHERE Username=? AND Password=?");
      ps.setString(1, username);
			ps.setString(2, password);
      ResultSet rs=ps.executeQuery();
      int i=0;
			while(rs.next()) {
				i+=1;
			}
			if(i!=0){
				result=true;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

  //register User
  public boolean register(String username,String password,String emailID){
    boolean result=false; int t=0;
    try {
            Connection cn=DBUtil.getConnection();
            PreparedStatement ps=cn.prepareStatement("INSERT INTO USERS VALUES(?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, emailID);
            t=ps.executeUpdate();
            
            if(t>0) {
		result=true;
            }

    }
    catch(SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return result;
  }
}
