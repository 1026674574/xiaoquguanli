package com.wlz.model;

public class Property {
    private int po_id;
    private int ho_id;
    private  float po_sevice;
    private  float po_admin;
    private String po_year;
    private int po_month;
    private String po_start;
    private String po_end;
    private int po_state;
    private House house;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getPo_state() {
        return po_state;
    }

    public void setPo_state(int po_state) {

        this.po_state = po_state;
        if (po_state==0)
        {
            setFlag("未缴费");
        }
        else setFlag("已缴费");
    }

    public int getPo_id() {
        return po_id;
    }

    public void setPo_id(int po_id) {
        this.po_id = po_id;
    }

    public int getHo_id() {
        return ho_id;
    }

    public void setHo_id(int ho_id) {
        this.ho_id = ho_id;
    }

    public float getPo_sevice() {
        return po_sevice;
    }

    public void setPo_sevice(float po_sevice) {
        this.po_sevice = po_sevice;
    }

    public float getPo_admin() {
        return po_admin;
    }

    public void setPo_admin(float po_admin) {
        this.po_admin = po_admin;
    }

    public String getPo_year() {
        return po_year;
    }

    public void setPo_year(String po_year) {
        this.po_year = po_year;
    }

    public int getPo_month() {
        return po_month;
    }

    public void setPo_month(int po_month) {
        this.po_month = po_month;
    }

    public String getPo_start() {
        return po_start;
    }

    public void setPo_start(String po_start) {
        this.po_start = po_start;
    }

    public String getPo_end() {
        return po_end;
    }

    public void setPo_end(String po_end) {
        this.po_end = po_end;
    }
}
