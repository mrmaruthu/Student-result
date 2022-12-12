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


public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String regno=request.getParameter("regno");
			String name=request.getParameter("name");
		
		
		 
		  try {PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/taskm","root","Maruthu@1");
		    PreparedStatement ps=con.prepareStatement("select * from taskm.student");
		    
		   
		     ResultSet rs=ps.executeQuery();
		     

		     while(rs.next()){
		    	 if(rs.getString("regno").equals(regno)&&rs.getString("name").equals(name)) {
		    		 System.out.println(rs.getString("regno")+""+rs.getString("name")+"  "+
		    				 rs.getString("tamil")+" "+rs.getString("english")+"  "+
		    				 rs.getString("maths")+"  "+rs.getString("science")+"  "+rs.getString("social"));
		    		 response.setContentType("text/html");	 
		    		 RequestDispatcher rq=request.getRequestDispatcher("Home.jsp");
		    		 rq.include(request, response);
		    	     pw.write("     RegNO:-"+rs.getString("regno"));
		    		 pw.write("  ,Name:-  " +rs.getString("name"));
		    		 pw.write("  ,Tamil:-  "+rs.getString("tamil"));
		    		 pw.write("  ,English:-  "+rs.getString("english"));
		    		 pw.write("  ,Maths:- "+rs.getString("maths")+'\n');
		    		 pw.write("  ,Science:- "+rs.getString("science"));
		    		 pw.write("  ,Social:- "+rs.getString("social"));
		    		 
		    		
		    		 break;


		  }
		    	  
		     }
		     } catch (Exception e) {
			
			e.printStackTrace();
		}

	
	
	}

}
