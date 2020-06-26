package Placements;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class view extends HttpServlet {
 public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {
	 response.setContentType("text/html; charset= UTF-8");
	 PrintWriter pw = response.getWriter();
	 
	 try 
	 { 
	  Class.forName ("com.mysql.jdbc.Driver");
	  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ERP","root","pandu1089");
	  PreparedStatement ps = con.prepareStatement("select * from details ");
	 
	  
	  ResultSet rs = ps.executeQuery();
	  ResultSetMetaData rsmd = rs.getMetaData();
	  int i = rsmd.getColumnCount();
	  pw.print("<html>\n" +
"<head>\n" +
"<style>\n" +
"#dtable {\n" +
"    font-family: Times New Roman;\n" +
"    border-collapse: collapse;\n" +
"    width: 50%;\n" +
"}\n" +
"\n" +
"#dtable td, #dtable th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"\n" +
"#dtable tr:hover {background-color: #ddd;}\n" +
"\n" +
"#dtable th {\n" +
"    padding-top: 12px;\n" +
"    padding-bottom: 12px;\n" +
"    text-align: left;\n" +
"    background-color: #ff6633;\n" +
"    color: white;\n" +
"}\n" +
".button {\n" +
"    background-color: #ff6633; \n" +
"    border: none;\n" +
"    color: white;\n" +
"    padding: 15px 32px;\n" +
"    text-align: center;\n" +
"    text-decoration: none;\n" +
"    display: inline-block;\n" +
"    font-size: 16px;\n" +
"}\n" +
"</style>\n" +
"\n" +
"</head>\n" +
"<body>\n" +
"<h1 style=\"font-size: 50px\">Admin Student applied view</h1>\n" +
"<br/>\n" +
"<br/>\n" +
"<table id=\"dtable\">\n"  );
			
	  for (int j =1; j<=i ; j++)
	  {
		   pw.print("<th>"+rsmd.getColumnName(j)+"</th>");
	  }
      	pw.print("</tr>");
		
		while(rs.next())
		{ pw.print("<tr><td>" + rs.getString(1)+"</td><td>"+
	
	  rs.getString(2)+"</td><td>"+
	  rs.getString(3)+"</td><td>"+
	  rs.getString(4)+"</td><td>"+
	  rs.getString(5)+"</td><td>"+
	  rs.getString(6)+"</td><td>"+
	  rs.getString(7)+"</td><td>"+
	  rs.getString(8)+"</td><td>"+
	  rs.getString(9)+"</td><td>"+rs.getString(10)+"</td></tr>" );
	
			
	}
	pw.print("</table>");
	pw.println("</p>");
	
	
	 }
	 catch (Exception e2)
	 {e2.printStackTrace();}
		finally{pw.close();}
 }
}
	
	 
	 
		
		
	  
	  
		 
	 
