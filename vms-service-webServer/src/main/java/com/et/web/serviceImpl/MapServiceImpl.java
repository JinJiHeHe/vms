package com.et.web.serviceImpl;/**
 * Created by gaop on 2017/10/20.
 */

import com.et.terminalserver.protocols.business.bo.TUGpsInfo;
import com.et.web.baiduMap.GpsGoBaiDuUtil;
import com.et.web.dao.MapMapper;
import com.et.web.entity.HistoryGps;
import com.et.web.service.MapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/10/20 11:30
 */
@Service("mapService")
public class MapServiceImpl implements MapService {
    @Resource
    private MapMapper mapMapper;
    public List<HistoryGps> getGpsHistory(String id_num, String start_time, String end_time) {
             System.out.println("mapServiceImpl.....");
          List<TUGpsInfo> list=mapMapper.getHistory(id_num,start_time,end_time);
          List<HistoryGps> list2=new ArrayList<HistoryGps>();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          for(TUGpsInfo gpsInfo:list){
              HistoryGps historyGps=new HistoryGps();
              historyGps.setgTime(format.format(gpsInfo.getGTime()));
              historyGps.setSpeed(gpsInfo.getSpeed());
              historyGps.setDirection(gpsInfo.getDirection());
              historyGps.setMileage(gpsInfo.getMileage());
              historyGps.setLocatoinName(gpsInfo.getLocatoinName());
              double [] str=GpsGoBaiDuUtil.getBaiDu(gpsInfo.getLat(),gpsInfo.getLon());
              historyGps.setLon(str[1]);
              historyGps.setLat(str[0]);
              list2.add(historyGps);
          }
          return list2;
    }
}
