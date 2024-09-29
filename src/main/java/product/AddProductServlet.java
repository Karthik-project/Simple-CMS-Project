package product;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/addproduct")
@SuppressWarnings("serial")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	  HttpSession hs = req.getSession(false);	
	  if(hs==null) {
		  req.setAttribute("mesg", "session as expired");
		  req.getRequestDispatcher("mesg.jsp").forward(req, res);
	  }
	  else {
     ProductBean pb= new ProductBean();
	 String code=req.getParameter("code");
	 String name= req.getParameter("name");
	 int price  =Integer.parseInt(req.getParameter("price"));
	 int qty  =  Integer.parseInt(req.getParameter("qty"));
     pb.setCode(code);
     pb.setName(name);
     pb.setPrice(price);
     pb.setQty(qty);
     int k = AdminDAO.addproduct(pb);
     if(k>0) {
    	 req.getRequestDispatcher("addproduct.jsp").forward(req, res);
     }
     else {
    	 req.setAttribute("mesg", "product not added");
		  req.getRequestDispatcher("mesg.jsp").forward(req, res);
	 
     }
	  }
	}

}
