package com.wlz.servlet;

import com.wlz.dao.PropertyDaoImpl;
import com.wlz.dao.impl.PropertyDao;
import com.wlz.model.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@WebServlet(name = "propertyServlet" ,urlPatterns = "/propertyServlet")
public class propertyServlet extends HttpServlet {
    PropertyDao propertyDao = new PropertyDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.setAccessible(true);
            method.invoke(this, request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("id");
        if (idstr==null)
        {
            idstr ="0";
        }
        int id=0;
        if (!idstr.equals("0"))
        {
            id=Integer.parseInt(idstr);
        }
        ArrayList<Property> list = propertyDao.getList(id);
        request.setAttribute("properties",list);
        request.getRequestDispatcher("/WEB-INF/pages/property_list.jsp").forward(request,response);

    }

    protected void getProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Property property = propertyDao.getProperty(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("property",property);
        request.getRequestDispatcher("/WEB-INF/pages/property_edit.jsp").forward(request,response);
    }
    protected void updateProperty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Property property = new Property();
        property.setPo_sevice(Float.parseFloat(request.getParameter("service")));
        property.setPo_admin(Float.parseFloat(request.getParameter("admin")));
        property.setPo_state(Integer.parseInt(request.getParameter("state")));
        property.setPo_start(request.getParameter("stdate"));
        property.setPo_end(request.getParameter("endate"));
        property.setPo_month(Integer.parseInt(request.getParameter("mont")));
        property.setPo_year(request.getParameter("year"));
        property.setPo_id(Integer.parseInt(request.getParameter("id")));
        propertyDao.updateProperty(property);
    }
}