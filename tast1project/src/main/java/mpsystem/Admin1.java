package mpsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
	
	
	 
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskm","root","Maruthu@1");
	    PreparedStatement ps=con.prepareStatement("select * from taskm.admin ");
	     
	   
	     ResultSet rs=ps.executeQuery();
	     
	     while(rs.next()){
	    	 if(rs.getString("email").equals(email)&&rs.getString("password").equals(pass)) {
	    		 RequestDispatcher rq=request.getRequestDispatcher("Admin.jsp");
		 	     rq.forward(request, response);  
	    	 }else {
	    		 response.setContentType("text/html");
	    		 PrintWriter pw=response.getWriter();
	    		 pw.print("invaild email  and password");
	    		 RequestDispatcher rq=request.getRequestDispatcher("Admin1.jsp");
	    		 rq.include(request, response);
	    	 }
	    	  
	     }
	     } catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
	}

}
