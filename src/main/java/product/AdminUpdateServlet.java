package product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/updateserv")
@SuppressWarnings("serial")

public class AdminUpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	

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
	    		   pb.setPrice(Integer.parseInt(req.getParameter("price")));
	    		   pb.setQty(Integer.parseInt(req.getParameter("qty")));
	    		   int k = AdminDAO.update(pb);
	    		   if(k>0) 
	    		   {
	    			   req.getRequestDispatcher("updateproduct.jsp").forward(req, res);
	    		   }
	    		  
	    		 
	    	   }
	       }
	
	  }
	}

	
}
