package com.et.web.entity;/**
 * Created by gaop on 2017/9/29.
 */

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/9/29 14:42
 */
public class HistoryEntity {
        private double lon;
        private double lat;
        private String vid;
        private String start_time;
        private String end_time;

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

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
