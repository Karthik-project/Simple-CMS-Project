package product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/editserv")
@SuppressWarnings("serial")
public class EditProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    
		HttpSession hs = req.getSession(false);	
		  if(hs==null) {
			  req.setAttribute("mesg", "session as expired");
			  req.getRequestDispatcher("mesg.jsp").forward(req, res);
		  }
		  else {
		  
			   req.getRequestDispatcher("editproduct.jsp").forward(req, res);
			  
			  
		  }
	
	
	
	
	
	
	}

	

}
