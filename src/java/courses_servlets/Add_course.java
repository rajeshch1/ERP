/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Shashank
 */
public class Add_course extends HttpServlet {

    String status = "newly_created",s="";
     int no_credits,no_students = 0;
    
    RequestDispatcher rd ;
    
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        PrintWriter on = response.getWriter();
       String course_id = request.getParameter("course_id");
       String course_name = request.getParameter("course_name");
       String course_incharge = request.getParameter("course_incharge");
      s = request.getParameter("credits");
      if( s != null)
       no_credits = Integer.parseInt("" + s);
      
      System.out.println(course_name + " " + course_incharge + " " + no_credits);
      
      String query = "Insert into courses values('" + course_id + "','" + course_name + "','" + course_incharge + "','" + no_credits + "','" + no_students + "','" + status + "')";                        
      
      try{
          Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP","root","pandu1089");
      Statement st = con.createStatement();
      int ex = st.executeUpdate(query);
       String query1 =  "Select course_name,course_incharge,credits from courses";
       Statement st1 = con.createStatement();
      ResultSet rs = st.executeQuery(query1);
      
      
       if(ex == 1){
    //rd = request.getRequestDispatcher("/courses.html");
			//rd.include(request, response);
     on.print("<html>\n" +
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
"<h1 style=\"font-size: 50px\">Courses</h1>\n" +
"<br/>\n" +
"<br/>\n" +
"<table id=\"dtable\">\n" +
"  <tr>\n" +
"    <th>course</th>\n" +
"    <th>staff</th>\n" +
"	<th>credits</th>\n" +
"  </tr>" );
      while(rs.next()){
          on.print(" <tr>\n" +
"    <td><label >" + rs.getString("course_name") +"</label></td>\n" +
"    <td><label >" + rs.getString("course_incharge") +"</label></td>\n" +
"	<td><label >" + rs.getString("credits") + "</label></td>\n" + "</tr>");          
      }
      on.print("</table>\n" +
"<br/>\n" +
"<br/>\n" +
"<a href=\"add_new_course.html\" class=\"button\">Add new course </a>\n" +
"&nbsp;\n" +
"<a class=\"button\">Change Course status </a>\n" +
"\n" +
"</body>\n" +
"</html>");                   
    }
       else{
            rd = request.getRequestDispatcher("/add_new_course.html");
			rd.include(request, response);
              }
      }
      catch(Exception e){
          e.printStackTrace(); 
      }
      //finally{
         
      //}
      }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       doGet(request,response);
   }
}
