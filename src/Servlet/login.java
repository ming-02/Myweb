package Servlet;

import Beans.Student;
import Beans.Users;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import daos.UsersDao;
import tools.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import javax.swing.event.ListDataEvent;
import java.io.IOException;
import java.util.List;

//用来处理获得的请求和返回的用户信息
@WebServlet("/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setCharacterEncoding("utf-8");
//        String username=request.getParameter( "username" );
//        String password=request.getParameter("password");
/*//        UsersDao usersDao=new UsersDao();
        Users user= DaoFactory.INSTANCE.login( username,password );
        RequestDispatcher rd;
        if (user!=null){
            rd=request.getRequestDispatcher( "WEB-INF/views/admin.jsp" );}
            else{
                rd=request.getRequestDispatcher( "login.jsp" );
            }
            request.setAttribute( "user",user );
            rd.forward( request,response );*/
//jquery.html
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Users user= DaoFactory.INSTANCE.login( username,password );
        ObjectMapper om=new ObjectMapper();
        response.getWriter().print(om.writeValueAsString(user));
        //vindex.html
      /*  response.setContentType("application/json");
        ObjectMapper om=new ObjectMapper();
        JsonNode jn=om.readTree(request.getReader());
        String username =jn.get("username").asText();
        String password =jn.get("password").asText();
        Users user11=DaoFactory.INSTANCE.loginVindex(username,password);
         if (user11==null){System.out.println("user为空");}else{
             System.out.println("不为空");
         }
          response.getWriter().print(om.writeValueAsString(user11));
     System.out.println("不符");*/
        //vindex1.html
       /* request.setCharacterEncoding( "utf-8" );
        response.setContentType("text/html;charset=UTF-8");
        ObjectMapper om=new ObjectMapper();
        JsonNode jn=om.readTree(request.getReader());
        String username =jn.get("sname").asText();
        System.out.println(username);
        List<Student> list=DaoFactory.INSTANCE.findStudentsByName1(username);
        response.getWriter().print(om.writeValueAsString(list));*/

    }
}

