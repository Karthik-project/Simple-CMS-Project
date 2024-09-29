package product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/deleteserv")
@SuppressWarnings("serial")

public class AdminDeleteServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		 HttpSession hs = req.getSession(false);	
		  if(hs==null) {
			  req.setAttribute("mesg", "session as expired");
			  req.getRequestDispatcher("mesg.jsp").forward(req, res);
		  }
		  else {
		ArrayList<ProductBean> al =(ArrayList<ProductBean>) hs.getAttribute("albean");
		       Iterator<ProductBean> il = al.iterator();
		      String code = req.getParameter("code");
		       while(il.hasNext()) 
		       {
		    	   ProductBean pb = il.next();
		    	   if(code.equals(pb.getCode())) 
		    	   {
		    		   
		    		   int k = AdminDAO.delete(pb);
		    		   if(k>0) 
		    		   {
		    			   req.getRequestDispatcher("deleteproduct.jsp").forward(req, res);
		    		   }
		    		  
		    		 
		    	   }
		       }
		
		
		
		  }
	}
}

	

