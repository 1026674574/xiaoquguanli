package com.wlz.dao;

import com.wlz.dao.impl.HouseDao;
import com.wlz.dao.impl.UserInfoDao;
import com.wlz.db.DBConnection;
import com.wlz.model.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
