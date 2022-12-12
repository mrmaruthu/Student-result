package mpsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
    	   String no=req.getParameter("regno");
  		 String name=req.getParameter("name");
  		 String mark1=req.getParameter("tamil");
  		 String mark2=req.getParameter("english");
  		 String mark3 =req.getParameter("maths");
  		 String mark4=req.getParameter("science");
  		String mark5=req.getParameter("social");
  		 
  		  try {
  			Class.forName("com.mysql.cj.jdbc.Driver");
  			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskm","root","Maruthu@1");
  		    PreparedStatement ps=con.prepareStatement("insert into taskm.student value(?,?,?,?,?,?,?)");
  		    ps.setString(1,no);
  		    ps.setString(2,name);
  		    ps.setString(3,mark1);
  		    ps.setString(4,mark2);
  		    ps.setString(5,mark3);
  		    ps.setString(6,mark4);
  		    ps.setString(7, mark5);
  		     
  		    ps.executeUpdate();
  		    res.setContentType("text/html");
 		    PrintWriter pw=res.getWriter();
 		      pw.print("Successful inserted");
 		    RequestDispatcher rq=req.getRequestDispatcher("Admin.jsp");
 		    rq.include(req, res);
  		       
  		     
  		    
  		    
  		  } catch (Exception e) {
  			
  			e.printStackTrace();
  		}
  		
       
       
       }

}
