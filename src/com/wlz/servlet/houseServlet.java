package com.wlz.servlet;

import com.wlz.dao.HouseDaoImpl;
import com.wlz.dao.impl.HouseDao;
import com.wlz.model.House;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@WebServlet(name = "HouseServlet", urlPatterns = "/houseServlet")
public class houseServlet extends HttpServlet {
    HouseDao houseDao = new HouseDaoImpl();
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
        ArrayList<House> list = houseDao.getList();
        request.setAttribute("houses",list);
        request.getRequestDispatcher("/WEB-INF/pages/house_list.jsp").forward(request,response);
    }
    protected void getHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        House house = houseDao.getHouse(id);
        request.setAttribute("house",house);
        request.getRequestDispatcher("/WEB-INF/pages/house_edit.jsp").forward(request,response);
    }

    protected void updateHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        House house = new House();
        house.setHo_type(request.getParameter("type"));
        house.setHo_area(Integer.parseInt(request.getParameter("area")));
        house.setHo_hao(Integer.parseInt(request.getParameter("hao")));
        house.setHo_dan(Integer.parseInt(request.getParameter("dan")));
        house.setHo_dong(Integer.parseInt(request.getParameter("dong")));
        house.setHo_hao(Integer.parseInt(request.getParameter("state")));
        houseDao.updateHouse(house);
    }
    protected void deleteHouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        houseDao.deleteHouse(id);

    }

}
