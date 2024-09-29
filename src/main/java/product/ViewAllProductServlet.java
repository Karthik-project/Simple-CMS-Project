package product;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/viewall")
@SuppressWarnings("serial")

public class ViewAllProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		 HttpSession hs = req.getSession(false);	
		  if(hs==null) {
			  req.setAttribute("mesg", "session as expired");
			  req.getRequestDispatcher("mesg.jsp").forward(req, res);
		  }
		  else {
			  ArrayList<ProductBean> al = AdminDAO.review();
			  if(al==null) {
				  req.setAttribute("mesg", "Product Not Existed...");
				  req.getRequestDispatcher("mesg.jsp").forward(req, res);
			
			  }
			  else {
				  hs.setAttribute("albean", al);
				  req.getRequestDispatcher("ViewAllProduct.jsp").forward(req, res);
			  }
		  }
	
	
	
	}

	
}
