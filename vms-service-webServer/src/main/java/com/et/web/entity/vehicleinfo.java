package com.et.web.entity;

import java.util.Date;

/**
 * Created by gaop on 2017/8/9.
 *
 */
public class vehicleinfo {
private int vehicle_id;
private String vehicle_num;
private String vehicle_color;
private String sim_id;
private String terminal_id;
private String org_id;
private int scrapped_flag;
private String vehicle_type;
private String terminal_type;
private Date modify_time;
private int terminal_interval;

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_num() {
        return vehicle_num;
    }

    public void setVehicle_num(String vehicle_num) {
        this.vehicle_num = vehicle_num;
    }

    public String getVehicle_color() {
        return vehicle_color;
    }

    public void setVehicle_color(String vehicle_color) {
        this.vehicle_color = vehicle_color;
    }

    public String getSim_id() {
        return sim_id;
    }

    public void setSim_id(String sim_id) {
        this.sim_id = sim_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public int getScrapped_flag() {
        return scrapped_flag;
    }

    public void setScrapped_flag(int scrapped_flag) {
        this.scrapped_flag = scrapped_flag;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getTerminal_type() {
        return terminal_type;
    }

    public void setTerminal_type(String terminal_type) {
        this.terminal_type = terminal_type;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    public int getTerminal_interval() {
        return terminal_interval;
    }

    public void setTerminal_interval(int terminal_interval) {
        this.terminal_interval = terminal_interval;
    }
}
