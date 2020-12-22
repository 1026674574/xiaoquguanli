package com.wlz.dao.impl;

import com.wlz.model.Admin;

import java.util.ArrayList;

public interface AdminDao {
    Admin login(String username, String password);
    ArrayList<Admin> getAdminList();
    Admin getAdmin(int id);
}
