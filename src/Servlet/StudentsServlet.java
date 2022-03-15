package Servlet;

import Beans.com.hw.Students;
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

@WebServlet("/StudentsSelect")
public class StudentsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setContentType( "utf-8" );
        response.setCharacterEncoding( "utf-8" );
        String name=request.getParameter( "name" );
        String classname=request.getParameter( "classname" );
        List<Students> stu= DaoFactory.INSTANCE.findStudents( name,classname );
        ObjectMapper map=new ObjectMapper(  );
        request.setAttribute( "stu",map.writeValueAsString(stu) );
        RequestDispatcher rd=request.getRequestDispatcher( "Students.jsp" );
        rd.forward( request,response );

    }
}
