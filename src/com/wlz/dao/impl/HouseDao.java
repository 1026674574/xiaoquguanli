package com.wlz.dao.impl;

import com.wlz.model.House;

import java.util.ArrayList;

public interface HouseDao {
    House getHouse(int id);
    ArrayList<House> getList();
    void updateHouse(House house);
}
