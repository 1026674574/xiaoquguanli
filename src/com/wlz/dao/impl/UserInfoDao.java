package com.wlz.dao.impl;

import com.wlz.model.UserInfo;

import java.util.ArrayList;

public interface UserInfoDao {

    UserInfo getUser(int id);
    ArrayList<UserInfo> getList();
    void updateUser(UserInfo userInfo);
    void deleteUser(int id);
    UserInfo login(String username, String password);
}
