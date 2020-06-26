/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Placements;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Placement_add extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
	 response.setContentType("text/html;charset=UTF-8 ");
     PrintWriter pw = response.getWriter();
		String Company_name = request.getParameter("Company_name");
		String company_over = request.getParameter("company_over");
		String location = request.getParameter("location");
		String job = request.getParameter("job");
		String cgpa = request.getParameter("cgpa");
		String stipend = request.getParameter("stipend");
		String ctc = request.getParameter("ctc");
		String Qualifi = request.getParameter("Qualifi");
		String respon = request.getParameter("respon");
		String reference = request.getParameter("reference");
	       try{
			    Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://Localhost/ERP","root","pandu1089");
				PreparedStatement ps = con.prepareStatement("insert into details values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,Company_name);
				ps.setString(2,company_over);
				ps.setString(3,location);
				ps.setString(4,job);
				ps.setString(5,cgpa);
				ps.setString(6,stipend);
				ps.setString(7,ctc);
				ps.setString(8,Qualifi);
				ps.setString(9,respon);
				ps.setString(10,respon);
				
				int i = ps.executeUpdate();
				
				if(i>0)
				{
					
					RequestDispatcher rd=request.getRequestDispatcher("place.html");
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
				
			    
			   
