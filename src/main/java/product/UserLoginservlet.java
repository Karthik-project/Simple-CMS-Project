package product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/userloginserv")
@SuppressWarnings("serial")

public class UserLoginservlet  extends HttpServlet{
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    UserBean ub = new UserBean();
    ub.setUname(req.getParameter("uname"));
	ub.setPassword( req.getParameter("pwrd"));
	UserBean ub1 = UserDAO.check(ub);
	if(ub1==null) 
	{
		req.setAttribute("mesg","Registration failed...");
		req.getRequestDispatcher("mesg.jsp").forward(req, res);
	}
	else 
	{
		HttpSession hs = req.getSession();
		hs.setAttribute("ubean", ub1);
		req.getRequestDispatcher("userlogin.jsp").forward(req, res);
		
	}
	
	}

}
