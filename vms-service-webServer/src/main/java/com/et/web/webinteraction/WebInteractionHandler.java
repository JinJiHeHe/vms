package com.et.web.webinteraction;


import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.protocols.business.bo.TUGpsInfo;
import com.et.web.baiduMap.GeocodingAddress;
import com.et.web.entity.DataGrid;
import com.et.web.entity.DataGridGps;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/29 9:14
 */
@Service("webInteraction")
public class WebInteractionHandler implements WebInteraction{
    private LocalCache lastGps= LocalCacheManager.getCache("_lastGps");
    private LocalCache test=LocalCacheManager.getCache("test");

    // 车辆信息的缓存 <vid,车辆信息>
    private LocalCache vehicleCache = LocalCacheManager.getCache("_relation");
       public DataGrid getGpsByVid(String vid ){
        System.out.println("test:"+test.get("test"));
        TUGpsInfo info= (TUGpsInfo) lastGps.get(vid);
        System.out.println("tugpsinfo...."+info);
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String location=info.getLat()+","+info.getLon();
         String address= GeocodingAddress.getAddress(location);
        if(info!=null){
            System.out.println("tugpsinfo is not null "+info.getVehicleNumber());
            DataGridGps dataGridGps = new DataGridGps();
            dataGridGps.setLocation(address);
            dataGridGps.setVehicleID(info.getVehicleID());
            dataGridGps.setDirection(info.getDirection());
            dataGridGps.setgTime(format.format(info.getGTime()));
            dataGridGps.setLat(info.getLat());
            dataGridGps.setLon(info.getLon());
            dataGridGps.setMileage(info.getMileage());
            dataGridGps.setSim(info.getSim());
            dataGridGps.setSpeed(info.getSpeed());
            dataGridGps.setTerminalID(info.getTerminalID());
            dataGridGps.setTerminalType(info.getTerminalType());
            dataGridGps.setVehicleNumber(info.getVehicleNumber());
            if (info.getOnOffLineFlag() == 0 || info.getOnOffLineFlag() == 1) {
                dataGridGps.setState("在线");
            } else {
                dataGridGps.setState("离线");
            }
            List<DataGridGps> list = new ArrayList<DataGridGps>();
            list.add(dataGridGps);
            DataGrid dataGrid = new DataGrid();
            dataGrid.setRows(list);
            dataGrid.setTotal(list.size());
            return dataGrid;
        }
        else return null;
    }
}
