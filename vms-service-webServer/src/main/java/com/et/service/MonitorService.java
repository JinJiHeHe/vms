package com.et.service;

import com.et.entity.TreeNode;

import java.util.List;

/**
 * Created by gaop on 2017/8/9.
 */
public interface MonitorService {
    public List<TreeNode> getAllTree();
    public List<TreeNode> getMonitorTree(String groupischecked,String id);
}
