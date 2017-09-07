package com.et.web.controller;

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
    Gson gson=new Gson();
    @Resource
    private WebInteraction webInteraction;
    @RequestMapping(value = "/getPointByVid.do", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getGpsByVid(String vid){
        System.out.println("vid:"+vid);
        DataGrid dataGrid=new DataGrid();
        dataGrid=webInteraction.getGpsByVid(vid);
        System.out.println("mapController:"+dataGrid.getRows().get(0).getVehicleNumber());
        String map=gson.toJson(dataGrid);
        System.out.println(map);
        return map;
    }
}
