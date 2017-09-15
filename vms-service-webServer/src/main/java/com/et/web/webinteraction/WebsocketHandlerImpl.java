package com.et.web.webinteraction;
/**
 * Created by gaop on 2017/9/7.
 */

import com.et.terminalserver.common.bus.Command;
import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.terminalserver.protocols.business.bo.TUGpsInfo;
import com.et.terminalserver.terminalaccess.business.BusinessHandler;
import com.et.web.baiduMap.GeocodingAddress;
import com.et.web.entity.DataGrid;
import com.et.web.entity.DataGridGps;
import com.google.gson.Gson;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description：
 * @Author：gaop
 * @Version: 1.0
 * @Date: 2017/9/7 15:51
 */

public class WebsocketHandlerImpl implements WebSocketHandler{
    LocalCache cache= LocalCacheManager.getCache("monitorVid");
    Gson gson=new Gson();
    ExecutorService es= Executors.newSingleThreadExecutor();
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        System.out.println("websocket is connection..........");
        final LinkedBlockingQueue<Command> queue= BusinessHandler.pushMonitor;
        final WebSocketSession session=webSocketSession;
        es.submit(new Runnable() {
            public void run() {
                while(true){
                    System.out.println("websocket sendmessage....");

                    try {
                        final  Command command = queue.take();
                        TUGpsInfo info= (TUGpsInfo) command.getParam();
                        String vid=info.getVehicleID();
                        System.out.println("handleMessage...."+vid);
                        String location=info.getLat()+","+info.getLon();
                        String address= GeocodingAddress.getAddress(location);
                        if(cache.containsKey(vid)){
                            System.out.println("vid..."+vid);
                            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                DataGridGps dataGridGps = new DataGridGps();
                                dataGridGps.setLocation(address);
                                dataGridGps.setVehicleID(info.getVehicleID());
                                dataGridGps.setDirection(info.getDirection());
                                dataGridGps.setgTime(format.format(info.getgTime()));
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
                            session.sendMessage(new TextMessage(gson.toJson(dataGrid)));
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });
    }

    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {




    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
                     System.out.println("websocket is error..........");
    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
            System.out.println("websocket is closed...............");
    }

    public boolean supportsPartialMessages() {
        return false;
    }


}
