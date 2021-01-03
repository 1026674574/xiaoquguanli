package com.wlz.dao;
import com.wlz.dao.impl.HouseDao;
import com.wlz.dao.impl.PropertyDao;
import com.wlz.db.DBConnection;
import com.wlz.model.House;
import com.wlz.model.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PropertyDaoImpl implements PropertyDao {
    DBConnection db = new DBConnection();
    HouseDao houseDao = new HouseDaoImpl();
    @Override
    public ArrayList<Property> getList(int id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Property> properties = new ArrayList<>();
        try {
            String sql = "select * from property";
            if (id != 0)
            {
                sql+=" where ho_id = "+id+" and po_state = 0";
            }
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Property property = new Property();
                property.setPo_id(resultSet.getInt("po_id"));
                property.setHo_id(resultSet.getInt("ho_id"));
                property.setPo_admin(resultSet.getFloat("po_admin"));
                property.setPo_sevice(resultSet.getFloat("po_sevice"));
                property.setPo_month(resultSet.getInt("po_month"));
                property.setPo_year(resultSet.getString("po_year"));
                property.setPo_end(resultSet.getString("po_end"));
                property.setPo_start(resultSet.getString("po_start"));
                property.setPo_state(resultSet.getInt("po_state"));
                property.setHouse(houseDao.getHouse(property.getPo_id()));
                properties.add(property);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return properties;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;

    }

    @Override
    public Property getProperty(int id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from property ";
            if (id != 0)
            {
                sql+=" where po_id = "+id;
            }
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Property property = new Property();
                property.setPo_id(resultSet.getInt("po_id"));
                property.setHo_id(resultSet.getInt("ho_id"));
                property.setPo_admin(resultSet.getFloat("po_admin"));
                property.setPo_sevice(resultSet.getFloat("po_sevice"));
                property.setPo_month(resultSet.getInt("po_month"));
                property.setPo_year(resultSet.getString("po_year"));
                property.setPo_end(resultSet.getString("po_end"));
                property.setPo_start(resultSet.getString("po_start"));
                property.setPo_state(resultSet.getInt("po_state"));
                property.setHouse(houseDao.getHouse(property.getPo_id()));
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return property;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateProperty(Property property) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update property set po_service = ? ,po_admin = ?, po_year = ? " +
                    ", po_month = ?, po_state = ?, po_start = ?, po_end = ? where po_id = ?");
        preparedStatement.setFloat(1,property.getPo_sevice());
        preparedStatement.setFloat(2,property.getPo_admin());
        preparedStatement.setString(3,property.getPo_year());
        preparedStatement.setInt(4,property.getPo_month());
        preparedStatement.setInt(5,property.getPo_state());
        preparedStatement.setString(6,property.getPo_start());
        preparedStatement.setString(7,property.getPo_end());
        preparedStatement.setInt(8,property.getPo_id());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProperty(int id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update property set po_state = 1 where po_id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
