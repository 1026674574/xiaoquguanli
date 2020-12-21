package com.wlz.model;

public class Warranty {
    private int wa_id;
    private int us_id;
    private String wa_text;
    private  String wa_datetime;
    private  int wa_state;
    private String wa_back;

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
    }

    public String getWa_back() {
        return wa_back;
    }

    public void setWa_back(String wa_back) {
        this.wa_back = wa_back;
    }
}
