package com.et.web.controller;

import com.et.web.entity.TreeNode;
import com.et.web.service.MonitorService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaop on 2017/8/4.
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
    Gson gson=new Gson();
    @Resource
    private MonitorService monitorService;
@RequestMapping("/getGroupTree.do")
@ResponseBody
public List<TreeNode> getGroupTree(String groupischecked,String id){
    System.out.println("come on...."+"checked:"+groupischecked+" id:"+id);
    List<TreeNode> list= monitorService.getMonitorTree(groupischecked,id);
    for(TreeNode node:list){
        System.out.println(node.getChildren().get(1).getText());
    }
  // String json= gson.toJson(list);
     return list;
}
}
