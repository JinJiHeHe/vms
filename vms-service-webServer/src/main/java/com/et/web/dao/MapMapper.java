package com.et.web.dao;/**
 * Created by gaop on 2017/8/29.
 */

import com.et.terminalserver.protocols.business.bo.TUGpsInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/29 11:06
 */
@Repository("mapMapper")
public interface MapMapper {
      @Select("select * from v_gpsinfo v where v.vehicleNumber=#{0} and v.gTime>=#{1} and v.gTime<=#{2} ORDER BY v.gTime")
       public List<TUGpsInfo> getHistory(String id_num, String start_time, String end_tiame);
}
