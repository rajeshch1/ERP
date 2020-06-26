package Complaints;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Complaint_add extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
	 response.setContentType("text/html;charset=UTF-8 ");
     PrintWriter pw = response.getWriter();
		String Department_name = request.getParameter("Department_name");
		String complaint_over = request.getParameter("complaint_over");
		
	       try{
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://Localhost/ERP","root","pandu1089");
				PreparedStatement ps = con.prepareStatement("insert into complaint values(?,?)");
				ps.setString(1,Department_name);
				ps.setString(2,complaint_over);
				
				
				int i = ps.executeUpdate();
				
				if(i>0)
				{
					
					RequestDispatcher rd=request.getRequestDispatcher("complaintplace.html");
			            rd.forward(request,response);
						 pw.println("<script type=\"text/javascript\">");
					   pw.println("alert('sucessfully added');");
					   
					   pw.println("</script>");
				 
				}
		   }
		   catch(Exception se)
		   {
			   se.printStackTrace();
		   }
	}
}
				
			    
			   