package com.wlz.model;

public class Warranty {
    private int wa_id;
    private int us_id;
    private int ad_id;
    private String wa_text;
    private  String wa_datetime;
    private  int wa_state;
    private String wa_back;
    private UserInfo userInfo;
    private Admin admin;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getAd_id() {
        return ad_id;
    }

    public void setAd_id(int ad_id) {
        this.ad_id = ad_id;
    }

    public Admin getAdmin() {
        if (this.admin==null)
            this.admin = new Admin("无");
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getWa_id() {
        return wa_id;
    }

    public void setWa_id(int wa_id) {
        this.wa_id = wa_id;
    }

    public int getUs_id() {
        return us_id;
    }

    public void setUs_id(int us_id) {
        this.us_id = us_id;
    }

    public String getWa_text() {
        return wa_text;
    }

    public void setWa_text(String wa_text) {
        this.wa_text = wa_text;
    }

    public String getWa_datetime() {
        return wa_datetime;
    }

    public void setWa_datetime(String wa_datetime) {
        this.wa_datetime = wa_datetime;
    }

    public int getWa_state() {
        return wa_state;
    }

    public void setWa_state(int wa_state) {
        this.wa_state = wa_state;
        if (wa_state == 0)
        {
            setFlag("未处理");
        }
        else if (wa_state == 1)
        {
            setFlag("正在处理");
        }
        else
        {
            setFlag("已处理");
        }
    }

    public String getWa_back() {
        return wa_back;
    }

    public void setWa_back(String wa_back) {
        this.wa_back = wa_back;
    }
}
