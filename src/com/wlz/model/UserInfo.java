package com.wlz.model;

public class UserInfo {
    private int us_id;
    private  String us_name;
    private String us_password;
    private String us_truename;
    private String us_idcar;
    private int ho_id;
    private House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public String getUs_name() {
        return us_name;
    }

    public void setUs_name(String us_name) {
        this.us_name = us_name;
    }

    public String getUs_password() {
        return us_password;
    }

    public void setUs_password(String us_password) {
        this.us_password = us_password;
    }

    public String getUs_truename() {
        return us_truename;
    }

    public void setUs_truename(String us_truename) {
        this.us_truename = us_truename;
    }

    public String getUs_idcar() {
        return us_idcar;
    }

    public void setUs_idcar(String us_idcar) {
        this.us_idcar = us_idcar;
    }

    public int getHo_id() {
        return ho_id;
    }

    public void setHo_id(int ho_id) {
        this.ho_id = ho_id;
    }
}
