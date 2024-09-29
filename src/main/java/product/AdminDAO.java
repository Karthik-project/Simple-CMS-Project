package product;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class AdminDAO 
{
   
	public static  AdminBean login(AdminBean ab)
	{   AdminBean ab1 = null;
	   try {
		   Connection con = DbConnection.getCon();
		   PreparedStatement ps = con.prepareStatement("select * from admindetails where uname=? and pwrd=?");
		   ps.setString(1, ab.getUname());
		   ps.setString(2, ab.getPassword());
		  ResultSet rs = ps.executeQuery();
		  if(rs.next()) {
			  ab1= new AdminBean();
			  ab1.setUname(rs.getString(1));;
			  ab1.setPassword(rs.getString(2));
			  ab1.setFname(rs.getString(3));
		  }
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return ab1;
    }
	public static int addproduct(ProductBean pb) {
		int k=0;
		try {
			 Connection con = DbConnection.getCon();
	         PreparedStatement ps = con.prepareStatement("insert into  product58 values(?,?,?,?)");
	         ps.setString(1, pb.getCode());
	         ps.setString(2, pb.getName());
	         ps.setInt(3, pb.getPrice());
		     ps.setInt(4, pb.getQty());
		     k = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	


public static ArrayList<ProductBean> review(){
	ArrayList< ProductBean> al =null;
		try {
			  Connection con = DbConnection.getCon();
			  PreparedStatement ps = con.prepareStatement("select * from product58");
			  ResultSet rs = ps.executeQuery();
			 if(rs!=null) {
			  al = new ArrayList<ProductBean>();
			  while(rs.next()) {
				  ProductBean pb = new ProductBean();
				  pb.setCode(rs.getString(1));
				  pb.setName(rs.getString(2));
				  pb.setPrice(rs.getInt(3));
				  pb.setQty(rs.getInt(4));
				  al.add(pb);
			  }
			  
			 }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return al;
}
public static int update(ProductBean pb) {
	int k=0;
	try {
		  Connection con = DbConnection.getCon();
          PreparedStatement ps = con.prepareStatement("insert into product58 (price,qty) values(?,?)");
          ps.setInt(1, pb.getPrice());
          ps.setInt(2, pb.getQty());
         k = ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return k;
}

public static int delete(ProductBean pb) {
	int k=0;
	try {
		  Connection con = DbConnection.getCon();
          PreparedStatement ps = con.prepareStatement("delete from product58 where code=?");
          ps.setString(1, pb.getCode());
         k = ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return k;
}

}
