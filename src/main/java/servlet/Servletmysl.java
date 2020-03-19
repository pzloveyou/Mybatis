package servlet;
import service.Service;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/mysql")
public class Servletmysl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             request.setCharacterEncoding("utf-8");
             response.setContentType("text/html;charset=utf-8");
             String name=request.getParameter("text");
             String pwd=request.getParameter("pwd");
             Service se=new ServiceImpl();
             int count=se.Selectmysql(name,pwd);
             if(count>0){
                 request.getRequestDispatcher("login.jsp").forward(request,response);
             }else{
                 response.sendRedirect("index.jsp");
             }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
