package com.et.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaop on 2017/7/31.
 */
public class TreeNode {
    //树节点ID
    private String id;
    //树节点名称，要显示的文本
    private String text;
    //节点状态，open和closed
    private String state;
    //节点样式
    private String iconCls;
    //节点外加属性
    private Object attributes;
    //节点是否选中
    private boolean checked = false;
    public TreeNode(){
        this.state="open";
    }
    //子节点
     private List<TreeNode> children = new ArrayList<TreeNode>();

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
