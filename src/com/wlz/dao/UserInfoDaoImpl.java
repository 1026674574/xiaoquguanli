package com.wlz.dao;

import com.wlz.dao.impl.HouseDao;
import com.wlz.dao.impl.UserInfoDao;
import com.wlz.db.DBConnection;
import com.wlz.model.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfoDaoImpl implements UserInfoDao {
    DBConnection db = new DBConnection();
    HouseDao houseDao = new HouseDaoImpl();

    @Override
    public UserInfo getUser(int id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from userinfo where us_id = ?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setUs_id(resultSet.getInt("us_id"));
                userInfo.setHo_id(resultSet.getInt("ho_id"));
                userInfo.setUs_name(resultSet.getString("us_name"));
                userInfo.setUs_password(resultSet.getString("us_password"));
                userInfo.setUs_truename(resultSet.getString("us_truename"));
                userInfo.setUs_idcar(resultSet.getString("us_idcar"));
                userInfo.setHouse(houseDao.getHouse(userInfo.getHo_id()));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<UserInfo> getList() {
        ArrayList<UserInfo>  list= new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from userinfo ");
            resultSet = preparedStatement.executeQuery();
           while (resultSet.next())
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setUs_id(resultSet.getInt("us_id"));
                userInfo.setHo_id(resultSet.getInt("ho_id"));
                userInfo.setUs_name(resultSet.getString("us_name"));
                userInfo.setUs_password(resultSet.getString("us_password"));
                userInfo.setUs_truename(resultSet.getString("us_truename"));
                userInfo.setUs_idcar(resultSet.getString("us_idcar"));
                userInfo.setHouse(houseDao.getHouse(userInfo.getHo_id()));
                list.add(userInfo);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        ArrayList<UserInfo>  list= new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update userinfo set us_name = ?,us_password = ?,us_truename = ?,us_idcar = ? where us_id = ?");
            preparedStatement.setString(1,userInfo.getUs_name());
            preparedStatement.setString(2,userInfo.getUs_password());
            preparedStatement.setString(3,userInfo.getUs_truename());
            preparedStatement.setString(4,userInfo.getUs_idcar());
            preparedStatement.setInt(5,userInfo.getUs_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public UserInfo login(String username, String password) {

        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from userinfo where us_name = ? and  us_password = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setUs_id(resultSet.getInt("us_id"));
                userInfo.setHo_id(resultSet.getInt("ho_id"));
                userInfo.setUs_name(resultSet.getString("us_name"));
                userInfo.setUs_password(resultSet.getString("us_password"));
                userInfo.setUs_truename(resultSet.getString("us_truename"));
                userInfo.setUs_idcar(resultSet.getString("us_idcar"));
                userInfo.setHouse(houseDao.getHouse(userInfo.getHo_id()));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return userInfo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
