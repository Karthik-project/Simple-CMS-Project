package product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/adminserv")
@SuppressWarnings("serial")
public class AdminLoginServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   AdminBean ab1= new AdminBean();
	   ab1.setUname((String) req.getParameter("uname"));
	   ab1.setPassword((String) req.getParameter("pwrd"));
	   AdminBean ab = AdminDAO.login(ab1);
       if(ab==null) 
       {
    	   PrintWriter pw = res.getWriter();
    	   res.setContentType("text/html");
    	   pw.println("Password / user name Incorrect...");
    	   
       }
       else 
       {
    	 HttpSession hs = req.getSession(); 
    	 hs.setAttribute("ubean", ab);
    	 req.getRequestDispatcher("AdminLoginSuccess.jsp").forward(req, res);
    	 
       }
		
	
	}

	
}
