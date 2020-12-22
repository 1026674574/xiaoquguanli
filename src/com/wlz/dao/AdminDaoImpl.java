package com.wlz.dao;

import com.wlz.dao.impl.AdminDao;
import com.wlz.db.DBConnection;
import com.wlz.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao {
    DBConnection db = new DBConnection();
    @Override
    public Admin login(String username, String password) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from admin where ad_username = ? and ad_password = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Admin admin = new Admin();
                admin.setAd_id(resultSet.getInt("ad_id"));
                admin.setAd_idcar(resultSet.getString("ad_idcar"));
                admin.setAd_password(resultSet.getString("ad_password"));
                admin.setAd_username(resultSet.getString("ad_username"));
                admin.setAd_truename(resultSet.getString("ad_truename"));
                admin.setAd_phone(resultSet.getString("ad_phone"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return admin;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Admin> getAdminList() {
        ArrayList<Admin> admins = new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from admin");
            resultSet=preparedStatement.executeQuery();
             while (resultSet.next())
            {
                Admin admin = new Admin();
                admin.setAd_id(resultSet.getInt("ad_id"));
                admin.setAd_idcar(resultSet.getString("ad_idcar"));
                admin.setAd_password(resultSet.getString("ad_password"));
                admin.setAd_username(resultSet.getString("ad_username"));
                admin.setAd_truename(resultSet.getString("ad_truename"));
                admin.setAd_phone(resultSet.getString("ad_phone"));
                admins.add(admin);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
