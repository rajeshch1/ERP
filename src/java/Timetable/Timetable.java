package Timetable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shashank
 */
public class Timetable extends HttpServlet {

   
   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query =  "SELECT t.id, s.staff_name, d.day, p.period\n" +
"FROM StaffTimeTable t\n" +
"JOIN staff s on s.id = t.staffID\n" +
"JOIN day_of_week d on d.id =  t.dayID\n" +
"JOIN periods p on p.id = t.periodID\n" +
"ORDER BY t.id";
        PrintWriter on = response.getWriter();
        try{
          Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP","root","pandu1089");
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      
      on.print("<html>\n" +
"<head>\n" +
"<style>\n" +
"#dtable1 {\n" +
"    font-family: Times New Roman;\n" +
"    border-collapse: collapse;\n" +
"    width: 50%;\n" +
"}\n" +
"\n" +
"#dtable1 td, #dtable1 th {\n" +
"    border: 1px solid #ddd;\n" +
"    padding: 8px;\n" +
"}\n" +
"\n" +
"\n" +
"#dtable1 tr:hover {background-color: #ddd;}\n" +
"\n" +
"#dtable1 th {\n" +
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
"<h1 style=\"font-size: 50px\">TimeTable</h1>\n" +
"<br/>\n" +
"<br/>\n" +
"<table id=\"dtable1\">\n" +
"  <tr>\n" +
"    <th>Serial no.</th>\n" +
"    <th>Faculty name</th>\n" +
"	<th>Day</th>\n" +
"        <th>Period</th>\n" +
"  </tr>");
      while(rs.next()){
          //if(rs.getString("staff_name")=="Peter Parker"){
          on.print(" <tr>\n" +
"    <td><label >"+rs.getString("id") +"</label></td>\n" +
"    <td><label >"+rs.getString("staff_name") +"</label></td>\n" +
"	<td><label >"+ rs.getString("day")+"</label></td>\n" +
"        <td><label >"+ rs.getString("period")+"</label></td>\n" +
"  </tr>");
          //}
      }
      on.print("</table>\n" +
"<br/>\n" +
"<br/>\n" +
"<a  class=\"button\">Change Timetable</a>\n" +
"&nbsp;\n" +
"\n" +
"\n" +
"</body>\n" +
"</html>");
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }

    
}
