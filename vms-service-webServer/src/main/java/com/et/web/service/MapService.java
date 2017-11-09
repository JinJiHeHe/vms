package com.et.web.service;

import com.et.web.entity.HistoryGps;

import java.util.List;

/**
 * Created by gaop on 2017/10/20.
 */
public interface MapService {

    public List<HistoryGps> getGpsHistory(String id_num, String start_time, String end_time);
}
