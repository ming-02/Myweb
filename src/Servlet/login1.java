package Servlet;

import Beans.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/login1")
public class login1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        String sname = request.getParameter("sname");
        String sclass=request.getParameter( "sclass" );
        List<Student> list= DaoFactory.INSTANCE.findStudentsByName( sname ,sclass);
//        request.setAttribute( "result",lists );//存放数据
        ObjectMapper om=new ObjectMapper(  );
        request.setAttribute( "students",om.writeValueAsString(list) );
        //指定页面
        RequestDispatcher rd =request.getRequestDispatcher( "login1_1.jsp" );
        rd.forward( request,response );//请求转发
    }
}
