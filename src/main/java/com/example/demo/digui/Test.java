package com.example.demo.digui;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root=new TreeNode("0",null,"0");
        TreeNode node2=new TreeNode("2","0","0");
        TreeNode node3=new TreeNode("3","0","0");
        TreeNode node33=new TreeNode("33","3","0");
        TreeNode node34=new TreeNode("34","3","0");
        TreeNode node23=new TreeNode("23","2","0");
        TreeNode node4=new TreeNode("1","1","0");
        root.add(node23);
        root.add(node2);
        root.add(node3);
        root.add(node33);
        root.add(node34);
        root.add(node4);
        JSONObject json=JSONObject.fromObject(root);
        System.out.println(json.toString());
        node4.setChildren(null);
        System.out.println(JSONObject.fromObject(node4));
    }
    //递归生成树结构
    public List<TreeNode> generateTree(List<TreeNode> list){
        if(list!=null&&list.size()>0){
            for (TreeNode node:list
                 ) {
                List<TreeNode> treeNodeList=getList(node.getId());
                generateTree(treeNodeList);
                node.setChildren(treeNodeList);
            }
        }
        return list;
    }
    //根据id到数据中查询它的子节点数据
    public List<TreeNode> getList(String id){
        //sql
        return  new ArrayList<TreeNode>();
    }
}
