package Servlet;

import Beans.Users;
import tools.DBFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/List"})
public class ListUsers extends HttpServlet {
    public ListUsers() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out = response.getWriter();
        List<Users> list = new ArrayList();
        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
        Connection conn=null;

        try {
            String sql = "select * from zhuce";
            conn = DBFactory.INSTANCE.getConnection();
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Users user = new Users();
                user.setUsername( rs.getString( 1 ) );
                user.setPassword( rs.getString( 2 ) );
                list.add( user );
            }

            rs.close();
            ps.close();
        } catch (SQLException var15) {
            var15.printStackTrace();
        } finally {
            if (conn!=null) {
                DBFactory.INSTANCE.closeConnection( conn );
            }
        }

        Iterator var17 = list.iterator();

        while (var17.hasNext()) {
            Users o = (Users) var17.next();
            out.println( o.getUsername() + " " );
            out.println( o.getPassword() + "<br> " );
        }

        out.close();
    }
}