package com.wlz.dao.impl;

import com.wlz.model.Warranty;

import java.util.ArrayList;

public interface WarrantyDao {
    ArrayList<Warranty> getList();

    Warranty getWarranty(int id);

    void updateWarranty(int id,int state,String text);

    void deleteWarranty(int id);
}
