package com.et.web.serviceImpl;

import com.et.terminalserver.api.model.VehicleInfo;
import com.et.terminalserver.common.cache.LocalCache;
import com.et.terminalserver.common.cache.LocalCacheManager;
import com.et.web.dao.MonitorMapper;
import com.et.web.entity.Combobox;
import com.et.web.entity.TreeNode;
import com.et.web.entity.organization;
import com.et.web.entity.vehicleinfo;
import com.et.web.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gaop on 2017/8/9.
 */
@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {
    private LocalCache relationCache = LocalCacheManager.getCache("_relation");
    @Resource
    private MonitorMapper monitorMapper;
   public List<TreeNode> getAllTree(){
       List<TreeNode> list1=new ArrayList<TreeNode>();
       TreeNode treeNode = new TreeNode();
       treeNode.setId("1000");
       treeNode.setText("监控中心");
       List<TreeNode> list = new ArrayList<TreeNode>();
       List<organization> orgList = monitorMapper.getRootNode("1000_%");
       for (organization org : orgList) {
           TreeNode node = new TreeNode();
           node.setText(org.getOrg_name());
           node.setId(org.getOrg_id());
           System.out.println(org.getOrg_name());
           List<vehicleinfo> vehicle = monitorMapper.getVehicleByOrg(org.getOrg_id()+"_%");
           List<TreeNode> childNode = new ArrayList<TreeNode>();
           for (vehicleinfo v : vehicle) {
               TreeNode child = new TreeNode();
               System.out.println("hahahahaha");
               System.out.println("vehicle_id:"+v.getVehicle_id());
               child.setId(v.getVehicle_id());
               child.setText(v.getId_number());
               System.out.println(v.getId_number());
               childNode.add(child);
           }
           node.setChildren(childNode);
           list.add(node);
       }
       treeNode.setChildren(list);
       list1.add(treeNode);
       return list1;
   }
    public List<TreeNode> getMonitorTree(String id) {
       List<TreeNode> list=new ArrayList<TreeNode>();
       list=getAllTree();
//        if(id!=null&&id!=""){
//            if(id.equals("1000")){
//                list=getAllTree();
//            }
//            else{
//              List<vehicleinfo> vehicleinfoList=  monitorMapper.getVehicleByOrg(id+"_%");
//
//                   for(vehicleinfo v:vehicleinfoList){
//                       TreeNode child = new TreeNode();
//                       child.setId(v.getOrg_id());
//                       child.setText(v.getVehicle_num());
//                       list.add(child);
//                   }
//            }
//        }
//        else{
//          list=getAllTree();
//        }
         return list;
    }

    public List<Combobox> getAllVehicle() {
      ConcurrentHashMap<Object, Object> map= relationCache.getCacheMap();
      List<Combobox> list=new ArrayList<Combobox>();
      for(Map.Entry<Object,Object> entry:map.entrySet()){
         Combobox box=new Combobox();
         box.setVid((String) entry.getKey());
         box.setId_num(((VehicleInfo)entry.getValue()).getPlate());
         list.add(box);
      }
        return list;
    }

}
