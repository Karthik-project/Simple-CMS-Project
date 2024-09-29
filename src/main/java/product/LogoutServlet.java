package product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/logserv")
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	

	 HttpSession hs = req.getSession(false);	
	  if(hs==null) {
		  req.setAttribute("mesg", "session as expired");
		  
	  }
	  else {
		  hs.invalidate();
		  req.setAttribute("mesg", "Logout Successfull...");
	  }
	  req.getRequestDispatcher("mesg.jsp").forward(req, res);
	  }
}
