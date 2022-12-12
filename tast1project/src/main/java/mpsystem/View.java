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

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
			 PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskm","root","Maruthu@1");
		    PreparedStatement ps=con.prepareStatement("select * from taskm.student ");
		    ResultSet rs=ps.executeQuery();
		    while (rs.next()){
		    	
		    	
		    	 pw.write("RegNO  :-"+rs.getString("regno")+'\n');
	    		 pw.write("Name   :-  " +rs.getString("name")+'\n');
	    		 pw.write("Tamil  :-  "+rs.getString("tamil")+'\n');
	    		 pw.write("English:-  "+rs.getString("english")+'\n');
	    		 pw.write("Maths  :- "+rs.getString("maths")+'\n');
	    		 pw.write("Science:- "+rs.getString("science")+'\n');
	    		 pw.write("Social :- "+rs.getString("social")+'\n');
	    		 
	    		
		    	 
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
