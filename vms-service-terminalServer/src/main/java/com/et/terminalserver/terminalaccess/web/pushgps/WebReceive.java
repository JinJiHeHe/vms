package com.et.terminalserver.terminalaccess.web.pushgps;

import com.et.terminalserver.protocols.business.bo.TUGpsInfo;

/**
 * Created by gaop on 2017/8/24.
 */
public interface WebReceive {
    public void pushGpsToWeb(TUGpsInfo info);
}
