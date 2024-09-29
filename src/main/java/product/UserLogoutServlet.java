package product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/userlogoutserv")
@SuppressWarnings("serial")
public class UserLogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("mesg","session Expired");
		}
		else {
			hs.invalidate();
			req.setAttribute("mesg","Logout Successfully.....<br><h3> <a href='home.html'>Return</a></h3>");
		}
		req.getRequestDispatcher("mesg.jsp").forward(req, res);

	}

	
}
