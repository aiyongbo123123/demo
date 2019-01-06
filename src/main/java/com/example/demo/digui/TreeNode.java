package com.example.demo.digui;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String id;
    private String pid;
    private String name;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(String id, String pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }
public void add(TreeNode node){
        if(node.pid.equals(this.id)){
            this.children.add(node);
        }else {
            if(this.children!=null&&this.children.size()>0){
                for (TreeNode treeNode:children
                     ) {
                    treeNode.add(node);
                }
            }
        }
}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
