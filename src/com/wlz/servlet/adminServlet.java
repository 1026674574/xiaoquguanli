package com.wlz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "AdminServlet" ,urlPatterns = "/adminServlet")
public class adminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            // 执行相应的方法
            method.setAccessible(true);
            method.invoke(this,request,response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    protected void getPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request,response);
    }
    protected void getAdminList(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{

    }
}
