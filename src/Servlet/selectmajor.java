package Servlet;

import Beans.major;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectmajor")
public class selectmajor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setCharacterEncoding( "utf-8" );
        String sname=request.getParameter( "school" );
        System.out.println(sname);
        List<major> major = DaoFactory.INSTANCE.getMajor( sname );
        ObjectMapper om=new ObjectMapper(  );
        response.getWriter().print( om.writeValueAsString( major ) );
    }
}
