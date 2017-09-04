package com.et.terminalserver.terminalaccess.web.pushgps;/**
 * Created by gaop on 2017/8/24.
 */

import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.protocols.business.bo.TUGpsInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/8/24 15:26
 */
public class WebreceiveHandler implements WebReceive {
      Log log = LogFactory.getLog(WebreceiveHandler.class);
      public LocalCache lastGps= LocalCacheManager.getCache("lastGps");

      public void pushGpsToWeb(TUGpsInfo info){
          log.info("TUGpsinfo");
          lastGps.put(info.getVehicleID(),info);
      }
}
