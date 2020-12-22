package com.wlz.servlet;

import com.wlz.dao.AdminDaoImpl;
import com.wlz.dao.impl.AdminDao;
import com.wlz.model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet" ,urlPatterns = "/adminServlet")
public class adminServlet extends HttpServlet {
    AdminDao adminDAO = new AdminDaoImpl();
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
        String page = request.getParameter("page");
        request.getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp").forward(request, response);
    }

    protected void getAdminList(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        ArrayList<Admin> adminList = adminDAO.getAdminList();
        request.setAttribute("adminList",adminList);
        request.getRequestDispatcher("/WEB-INF/pages/admin_list.jsp").forward(request,response);
    }
    protected void login(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminDAO.login(username, password);
        if (admin==null)
        {
           getPage(request,response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("admin",admin);
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);

    }
}
