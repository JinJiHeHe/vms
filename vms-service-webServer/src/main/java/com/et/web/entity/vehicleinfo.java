package com.et.web.entity;

/**
 * Created by gaop on 2017/8/9.
 *
 */
public class vehicleinfo {
    /**
     * 车辆ID
     */
  private String vehicle_id; // 关系参照 车辆ID
    /**
     * 终端编码
     */
   private String terminal_code; // 关系参照 终端编码
    /**
     * 组织编号
     */
    String org_code; // 组织编号
    /**
     * 上传数据类型
     */
    int type_id; // 上传数据类型 0:终端接入 1:平台转发
    /**
     * 终端ID
     */
    String terminal_id; // 终端ID
    /**
     * 驾驶员ID
     */
    String driverId; // 驾驶员ID
    /**
     * 车牌号
     */
    String id_number; // 车牌号

    /**
     * 车辆颜色
     * */
    String color_id_number_id;

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getTerminal_code() {
        return terminal_code;
    }

    public void setTerminal_code(String terminal_code) {
        this.terminal_code = terminal_code;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getColor_id_number_id() {
        return color_id_number_id;
    }

    public void setColor_id_number_id(String color_id_number_id) {
        this.color_id_number_id = color_id_number_id;
    }

}
