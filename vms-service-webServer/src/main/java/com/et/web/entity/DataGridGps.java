package com.et.web.entity;


/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/29 11:38
 */
public class DataGridGps {
    /**
     * 车辆ID
     */
    private String vehicleID;

    private String location;//位置

    /**
     * 采集时间
     */
    private String gTime;
    /**
     * 经度
     */
    private double lon;
    /**
     * 纬度
     */
    private double lat;

    /**
     * 方向
     */
    private int direction;
    /**
     * 速度
     */
    private float speed;
    /**
     * 通讯卡号
     */
    private String sim;
    /**
     * 终端号
     */
    private String terminalID;
    /**
     * 里程
     */
    private double mileage;


    /**
     * 终端类型
     */
    private String terminalType;

    /**
     * 车牌号
     */
    private String vehicleNumber;

    /**
     * 上/下线标识
     */
    private String state;// 0.正常 1.上线 -1.离线

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getgTime() {
        return gTime;
    }

    public void setgTime(String gTime) {
        this.gTime = gTime;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
