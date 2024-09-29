package product;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/viewuserpdct")
@SuppressWarnings("serial")
public class UserViewProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
    HttpSession hs = req.getSession(false);
    if(hs==null) 
    {
    	req.setAttribute("mesg", "Session expired");
    	req.getRequestDispatcher("mesg.jsp").forward(req, res);
    }
    else
    {
    	ArrayList<ProductBean> al = UserDAO.review();
    	hs.setAttribute("albean", al);
    	req.getRequestDispatcher("userviewproduct.jsp").forward(req, res);
    }
		
		
		
		
	}
}
