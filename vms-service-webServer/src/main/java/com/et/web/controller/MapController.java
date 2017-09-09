package com.et.web.controller;

import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.web.entity.DataGrid;
import com.et.web.webinteraction.WebInteraction;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by gaop on 2017/8/28.
 */
@Controller
@RequestMapping("/map")
public class MapController{
    LocalCache cache= LocalCacheManager.getCache("monitorVid");

    Gson gson=new Gson();
    @Resource
    private WebInteraction webInteraction;
    @RequestMapping(value = "/getPointByVid.do", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getGpsByVid(String vid){

        //0是选中，1是未选中（其实没啥用，最后我也只是通过containskey判断一下）
        cache.put(vid,"0");
        System.out.println("vid:"+vid);
        DataGrid dataGrid=new DataGrid();
        dataGrid=webInteraction.getGpsByVid(vid);
        System.out.println("mapController:"+dataGrid.getRows().get(0).getVehicleNumber());
        String map=gson.toJson(dataGrid);
        System.out.println(map);
        return map;
    }
}
