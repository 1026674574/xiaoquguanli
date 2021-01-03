package com.wlz.servlet;

import com.wlz.dao.WarrantyDaoImpl;
import com.wlz.dao.impl.WarrantyDao;
import com.wlz.model.Admin;
import com.wlz.model.UserInfo;
import com.wlz.model.Warranty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@WebServlet(name = "WarrantyServlet",urlPatterns = "/warrantyServlet")
public class warrantyServlet extends HttpServlet {

    WarrantyDao warrantyDao = new WarrantyDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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

    protected void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Warranty> list = warrantyDao.getList();
        request.setAttribute("warrantys",list);
        request.getRequestDispatcher("/WEB-INF/pages/warranty_list.jsp").forward(request,response);

    }
    protected void getList2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        ArrayList<Warranty> list = warrantyDao.getList(userInfo.getUs_id());
        request.setAttribute("warrantys2",list);
        request.getRequestDispatcher("/WEB-INF/pages/user_maintain_list.jsp").forward(request,response);

    }
    protected void getPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String page = request.getParameter("page");
        request.getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp").forward(request, response);
    }
    protected void getWarranty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idstr = request.getParameter("id");
        int id = 0;
        id = Integer.parseInt(idstr);
        Warranty warranty = warrantyDao.getWarranty(id);
        request.setAttribute("warrranty",warranty);
        request.getRequestDispatcher("/WEB-INF/pages/warranty_edit.jsp").forward(request,response);
    }
    protected void getHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Warranty> list2 = warrantyDao.getList2();
        request.setAttribute("warrantys",list2);
        request.getRequestDispatcher("/WEB-INF/pages/warranty_history.jsp").forward(request,response);
    }
    protected void updateWarranty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idstr = request.getParameter("id");
        String statusstr = request.getParameter("status");
        String back = request.getParameter("back");
        int status = Integer.parseInt(statusstr);
        int id= Integer.parseInt(idstr);
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        warrantyDao.updateWarranty(id,status,back,admin.getAd_id());
        getList(request,response);

    }
    protected void deleteWarranty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void addWarranty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        String text = request.getParameter("text");
        String sadate = request.getParameter("sadate");
        Warranty warranty = new Warranty();
        warranty.setWa_text(text);
        warranty.setWa_datetime(sadate);
        warranty.setUs_id(userInfo.getUs_id());
        warrantyDao.addWarranty(warranty);
        getList2(request,response);

    }
}
