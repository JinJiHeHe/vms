package com.et.web.controller;

import com.et.web.entity.DataGrid;
import com.et.web.webinteraction.WebInteraction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by gaop on 2017/8/28.
 */
@Controller
@RequestMapping("/map")
public class MapController{
    @Resource
    private WebInteraction webInteraction;
    @RequestMapping("/getPointByVid.do")
    public DataGrid getGpsByVid(String vid){
        System.out.println("vid:"+vid);
        DataGrid dataGrid=new DataGrid();
        dataGrid=webInteraction.getGpsByVid(vid);
        System.out.println("mapController:"+dataGrid.getRows().get(0).getVehicleNumber());
        return dataGrid;
    }
}
