package com.et.web.serviceImpl;

import com.et.web.dao.MonitorMapper;
import com.et.web.entity.TreeNode;
import com.et.web.entity.organization;
import com.et.web.entity.vehicleinfo;
import com.et.web.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaop on 2017/8/9.
 */
@Service("monitorService")
public class MonitorServiceImpl implements MonitorService {
    @Resource
    private MonitorMapper monitorMapper;
   public List<TreeNode> getAllTree(){
       List<TreeNode> list1=new ArrayList<TreeNode>();
       TreeNode treeNode = new TreeNode();
       treeNode.setId("1000");
       treeNode.setText("监控中心");
       treeNode.setState("open");
       List<TreeNode> list = new ArrayList<TreeNode>();
       List<organization> orgList = monitorMapper.getRootNode("1000_%");
       for (organization org : orgList) {
           TreeNode node = new TreeNode();
           node.setText(org.getOrg_name());
           System.out.println(org.getOrg_name());
           List<vehicleinfo> vehicle = monitorMapper.getVehicleByOrg(org.getOrg_id()+"_%");
           List<TreeNode> childNode = new ArrayList<TreeNode>();
           for (vehicleinfo v : vehicle) {
               TreeNode child = new TreeNode();
               child.setId(v.getOrg_id());
               child.setText(v.getVehicle_num());
               System.out.println(v.getVehicle_num());
               childNode.add(child);
           }
           node.setChildren(childNode);
           list.add(node);
       }
       treeNode.setChildren(list);
       list1.add(treeNode);
       return list1;
   }
    public List<TreeNode> getMonitorTree(String groupischecked,String id) {
       List<TreeNode> list=new ArrayList<TreeNode>();
        if(id!=null&&id!=""){
            if(id.equals("1000")){
                list=getAllTree();
            }
            else{
              List<vehicleinfo> vehicleinfoList=  monitorMapper.getVehicleByOrg(id+"_%");

                   for(vehicleinfo v:vehicleinfoList){
                       TreeNode child = new TreeNode();
                       child.setId(v.getOrg_id());
                       child.setText(v.getVehicle_num());
                       list.add(child);
                   }
            }
        }
        else{
          list=getAllTree();
        }
         return list;
    }
}
