package com.et.web.service;

import com.et.web.entity.Combobox;
import com.et.web.entity.TreeNode;

import java.util.List;

/**
 * Created by gaop on 2017/8/9.
 */
public interface MonitorService {
    public List<TreeNode> getAllTree();
    public List<TreeNode> getMonitorTree(String id);
    public List<Combobox> getAllVehicle();
}
