package com.et.web.entity;/**
 * Created by gaop on 2017/10/20.
 */

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/10/20 15:15
 */
public class HistoryGps {
    private String gTime;
    private float speed;
    private int direction;
    private double mileage;
    private String alarmType;
    private String locatoinName;
    private double lon;
    private double lat;
    private String uploadType;

    public String getgTime() {
        return gTime;
    }

    public void setgTime(String gTime) {
        this.gTime = gTime;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getLocatoinName() {
        return locatoinName;
    }

    public void setLocatoinName(String locatoinName) {
        this.locatoinName = locatoinName;
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

    public String getUploadType() {
        return uploadType;
    }

    public void setUploadType(String uploadType) {
        this.uploadType = uploadType;
    }
}
