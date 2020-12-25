package com.wlz.servlet;

import com.wlz.dao.UserInfoDaoImpl;
import com.wlz.dao.impl.UserInfoDao;
import com.wlz.model.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@WebServlet(name = "UserInfoServlet",urlPatterns = "/userInfoServlet")
public class userInfoServlet extends HttpServlet {
    UserInfoDao userInfoDao = new UserInfoDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }

    protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<UserInfo> list = userInfoDao.getList();
        request.setAttribute("users",list);
        request.getRequestDispatcher("/WEB-INF/pages/userInfo_list.jsp").forward(request,response);
    }
    protected void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        UserInfo user = userInfoDao.getUser(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/pages/userInfo_edit.jsp").forward(request,response);

    }
    protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String idcar = request.getParameter("idcar");
        String truename = request.getParameter("truename");
        UserInfo userInfo = new UserInfo();
        userInfo.setUs_idcar(idcar);
        userInfo.setUs_truename(truename);
        userInfo.setUs_password(password);
        userInfo.setUs_name(username);
        userInfoDao.updateUser(userInfo);

    }
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{}
}
