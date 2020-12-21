package com.wlz.dao.impl;

import com.wlz.model.Admin;

import java.util.ArrayList;

public interface AdminDAO {
    Admin login(String username, String password);
    ArrayList<Admin> getAdminList();
}
