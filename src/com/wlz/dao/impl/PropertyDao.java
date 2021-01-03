package com.wlz.dao.impl;

import com.wlz.model.Property;

import java.util.ArrayList;


public interface PropertyDao {
    ArrayList<Property> getList(int id);
    Property getProperty(int id);
    void updateProperty(Property property);
    void  updateProperty(int id);
}
