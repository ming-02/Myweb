package Servlet;

import Beans.school;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sschool")
public class selectschool extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setCharacterEncoding( "utf-8" );
        List<school> school= DaoFactory.INSTANCE.getschool(  );
        System.out.println(school);
        ObjectMapper om=new ObjectMapper(  );
        response.getWriter().print( om.writeValueAsString( school ) );
    }
}
