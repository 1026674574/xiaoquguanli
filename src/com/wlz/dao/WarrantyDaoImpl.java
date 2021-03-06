package com.wlz.dao;
import com.wlz.dao.impl.AdminDao;
import com.wlz.dao.impl.UserInfoDao;
import com.wlz.dao.impl.WarrantyDao;
import com.wlz.db.DBConnection;
import com.wlz.model.Warranty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class WarrantyDaoImpl implements WarrantyDao {
    DBConnection db = new DBConnection();
    UserInfoDao userInfoDao = new UserInfoDaoImpl();
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public ArrayList<Warranty> getList() {
        ArrayList<Warranty> warranties = new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from warranty where wa_state = 0");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Warranty warranty = new Warranty();
                warranty.setWa_id(resultSet.getInt("wa_id"));
                warranty.setUs_id(resultSet.getInt("us_id"));
                warranty.setWa_back(resultSet.getString("wa_back"));
                warranty.setWa_datetime(resultSet.getString("wa_datetime"));
                warranty.setWa_state(resultSet.getInt("wa_state"));
                warranty.setWa_text(resultSet.getString("wa_text"));
                warranty.setUserInfo(userInfoDao.getUser(warranty.getUs_id()));
                warranty.setAdmin(adminDao.getAdmin(resultSet.getInt("ad_id")));
                warranties.add(warranty);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return warranties;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Warranty> getList2() {
        ArrayList<Warranty> warranties = new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from warranty where wa_state != 0");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Warranty warranty = new Warranty();
                warranty.setWa_id(resultSet.getInt("wa_id"));
                warranty.setUs_id(resultSet.getInt("us_id"));
                warranty.setWa_back(resultSet.getString("wa_back"));
                warranty.setWa_datetime(resultSet.getString("wa_datetime"));
                warranty.setWa_state(resultSet.getInt("wa_state"));
                warranty.setWa_text(resultSet.getString("wa_text"));
                warranty.setUserInfo(userInfoDao.getUser(warranty.getUs_id()));
                warranty.setAdmin(adminDao.getAdmin(resultSet.getInt("ad_id")));
                warranties.add(warranty);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return warranties;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Warranty> getList(int id) {
        ArrayList<Warranty> warranties = new ArrayList<>();
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from warranty where us_id = ?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Warranty warranty = new Warranty();
                warranty.setWa_id(resultSet.getInt("wa_id"));
                warranty.setUs_id(resultSet.getInt("us_id"));
                warranty.setWa_back(resultSet.getString("wa_back"));
                warranty.setWa_datetime(resultSet.getString("wa_datetime"));
                warranty.setWa_state(resultSet.getInt("wa_state"));
                warranty.setWa_text(resultSet.getString("wa_text"));
                warranty.setUserInfo(userInfoDao.getUser(warranty.getUs_id()));
                warranty.setAdmin(adminDao.getAdmin(resultSet.getInt("ad_id")));
                warranties.add(warranty);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return warranties;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Warranty getWarranty(int id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select * from warranty where wa_id = ?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
          if (resultSet.next())
          {
              Warranty warranty = new Warranty();
              warranty.setWa_id(resultSet.getInt("wa_id"));
              warranty.setUs_id(resultSet.getInt("us_id"));
              warranty.setWa_back(resultSet.getString("wa_back"));
              warranty.setWa_datetime(resultSet.getString("wa_datetime"));
              warranty.setWa_state(resultSet.getInt("wa_state"));
              warranty.setWa_text(resultSet.getString("wa_text"));
              warranty.setUserInfo(userInfoDao.getUser(warranty.getUs_id()));
              resultSet.close();
              preparedStatement.close();
              connection.close();
              return warranty;
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateWarranty(int id,int state,String text,int ad_id) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement= connection.prepareStatement("update warranty set wa_state = ?, wa_back = ? ,ad_id = ? where wa_id = ?");
            preparedStatement.setInt(1,state);
            preparedStatement.setString(2,text);
            preparedStatement.setInt(3,ad_id);
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWarranty(int id) {

    }

    @Override
    public void addWarranty(Warranty warranty) {
        Connection connection = db.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement=connection.prepareStatement("insert into warranty(wa_text,wa_datetime,us_id) values (?,?,?)");
            preparedStatement.setString(1,warranty.getWa_text());
            preparedStatement.setString(2,warranty.getWa_datetime());
            preparedStatement.setInt(3,warranty.getUs_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
