package com.wlz.dao;

import com.wlz.dao.impl.HouseDao;
import com.wlz.db.DBConnection;
import com.wlz.model.House;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HouseDaoImpl implements HouseDao {
    DBConnection db= new DBConnection();

    @Override
    public House getHouse(int id) {
        House house = new House();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
            try {
                preparedStatement = connection.prepareStatement("select * from house where ho_id = ? ");
                preparedStatement.setInt(1,id);
                resultSet=preparedStatement.executeQuery();
                if (resultSet.next())
                {
                    house.setHo_id(resultSet.getInt("ho_id"));
                    house.setHo_dan(resultSet.getInt("ho_dan"));
                    house.setHo_dong(resultSet.getInt("ho_dong"));
                    house.setHo_hao(resultSet.getInt("ho_hao"));
                    house.setHo_area(resultSet.getInt("ho_area"));
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return house;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return null;
}

    @Override
    public ArrayList<House> getList() {

        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<House> houses = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from house  ");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                House house = new House();
                house.setHo_id(resultSet.getInt("ho_id"));
                house.setHo_dan(resultSet.getInt("ho_dan"));
                house.setHo_dong(resultSet.getInt("ho_dong"));
                house.setHo_hao(resultSet.getInt("ho_hao"));
                house.setHo_area(resultSet.getInt("ho_area"));
                houses.add(house);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return houses;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateHouse(House house) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update house set ho_hao = ? , ho_dong = ?, ho_dan = ?, ho_area = ? WHERE ho_id = ?");
            preparedStatement.setInt(1,house.getHo_hao());
            preparedStatement.setInt(2,house.getHo_dong());
            preparedStatement.setInt(3,house.getHo_dan());
            preparedStatement.setInt(4,house.getHo_area());
            preparedStatement.setInt(5,house.getHo_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}