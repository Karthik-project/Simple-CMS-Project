package product;
import static product.DbDetails.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConnection {
  
	public static Connection getCon() {
		Connection con=null;
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url,uname,pwrd);
				
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 return con;
	}
	
}
