package com.et.controller;

import com.et.entity.TreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by gaop on 2017/8/4.
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
@RequestMapping("/getGroupTree.do")
@ResponseBody
public List<TreeNode> getGroupTree(String groupischecked, String treeStatus){
    if (null == treeStatus || "".equals(treeStatus)) {
        treeStatus = "0";
    }

    return null;
}
}
