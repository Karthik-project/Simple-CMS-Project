package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import product.UserBean;
public class UserDAO {
 public static UserBean  check(UserBean ub) {
	 UserBean k=null;
	 try {
		 Connection con=DbConnection.getCon();
	     PreparedStatement ps = con.prepareStatement("select * from users where uname=? and password=?");
	     ps.setString(1, ub.getUname());
	     ps.setString(2,ub.getPassword());
	     ResultSet rs = ps.executeQuery();
	     if(rs.next()) {
	    	k= new UserBean();
	    	k.setUname(rs.getString(1));
	    	k.setEmail(rs.getString(2));
	    	k.setPassword(rs.getString(3));
	    	k.setAmount(rs.getInt(4));
	    	
	     }
		 
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
 public static int transcation(ProductBean pb,int qty,String uname,String address) {
	  int k=0;
	 try {
		  Connection con = DbConnection.getCon();
		  PreparedStatement ps = con.prepareStatement("insert into producttransaction values(?,?,?,?,?,?) where code=?");
		  ps.setString(1, pb.getCode());
		  ps.setString(2, pb.getName());
		  ps.setString(3, uname);
		  ps.setString(4, address);
		  ps.setInt(5, qty);
		  ps.setInt(6, qty*pb.getPrice());
		  ps.setString(7,pb.getCode());
		  k = ps.executeUpdate();
	 }
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 return k;
 }
 public static int addcart(ProductBean pb) {
	 
 }
	
}
