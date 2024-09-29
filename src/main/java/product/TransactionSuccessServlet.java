package product;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/usertransserv")
@SuppressWarnings("serial")
public class TransactionSuccessServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    HttpSession hs = req.getSession(false);
    if(hs==null) {
    	req.setAttribute("mesg", " user Session expired Please Login again....");
    	req.getRequestDispatcher("mesg.jsp").forward(req, res);
    }
    else {
    	int transaction=0;
    	ProductBean pb = (ProductBean)req.getAttribute("pb");
    	String code = pb.getCode();
    	UserBean ub = (UserBean) hs.getAttribute("ubean");
    	String uname=ub.getUname();
    	String address=req.getParameter("address");
    	int qty = Integer.parseInt(req.getParameter("qty"));
    	ArrayList<ProductBean> al= (ArrayList<ProductBean>) hs.getAttribute("albean");
    	Iterator<ProductBean> il =al.iterator();
    	while(il.hasNext()){
    		ProductBean pb1= (ProductBean)il.next();
           if(code.equals(pb1.getCode())) {
        	   pb1.setQty(pb1.getQty()-qty);
        	   transaction = UserDAO.transcation(pb1,qty,uname,address);
           }
    	}
    	if(transaction>0) {
    		PrintWriter pw = res.getWriter();
    		res.setContentType("text/html");
    		pw.print("<h3>Product Booked Successfully..</h3>");
    		pw.print("<a href='userlogin.jsp' >return</a>");
    	}
    }   
	}
    	
    }


