package product;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/usercartserv")
@SuppressWarnings("serial")
public class UserCartServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		 HttpSession hs = req.getSession(false);
		    if(hs==null) {
		    	req.setAttribute("mesg", " Session expired please login again");
		    	req.getRequestDispatcher("mesg.jsp").forward(req, res);
		    }
		    else {
		    	 ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("albean");
		    	 String code=req.getParameter("code");
		    	Iterator<ProductBean> il = al.iterator();
		    	while(il.hasNext()){
		    		ProductBean pb= (ProductBean)il.next();
		           if(code.equals(pb.getCode())) {
		        	
		        	   
		        	  
		           } 
		           
		    	}
		    }
		
	}

	
}
