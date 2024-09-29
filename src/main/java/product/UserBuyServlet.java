package product;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/userbuyserv")
@SuppressWarnings("serial")
public class UserBuyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession hs = req.getSession(false);
    if(hs==null) {
    	req.setAttribute("mesg", " user Session expired Please Login again....");
    	req.getRequestDispatcher("mesg.jsp").forward(req, res);
    }
    else {
    	
    	String pcode = req.getParameter("code");
    	ArrayList<ProductBean> al= (ArrayList<ProductBean>) req.getAttribute("albean");
    	Iterator<ProductBean> il =al.iterator();
    	while(il.hasNext()){
    		ProductBean pb= (ProductBean)il.next();
    		if(pcode.equals(pb.getCode())) {
    			req.setAttribute("pcode", pcode);
    		}
    }
    	req.getRequestDispatcher("").forward(req, res);
		
		
}
}