package Servlet;

import Beans.SchoolMajor;
import Beans.school;
import com.fasterxml.jackson.databind.ObjectMapper;
import tools.DBFactory;
import tools.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/getSchoolMajor")
public class getSchoolMajor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        List<SchoolMajor> list= DaoFactory.INSTANCE.getSchoolMajors();
        ObjectMapper om=new ObjectMapper();
        response.getWriter().print(om.writeValueAsString(list));

    }
}
