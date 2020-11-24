package com.component;

import java.util.*;

//用水区域，用水节点的集合，包含用水区域的基本参数（区域代号,区域内用水节点列表，区域总流量消耗，区域总压力需求）
public class UserArea extends UserNode{
    
    public List<UserNode> userAreaList = new ArrayList<UserNode>();
    public Map<String, UserNode> userAreaMap = new HashMap<String, UserNode>(); 
    
    // public UserArea(){
    //     this.name = null;
    //     this.reqQuantity = -1;
    // }
    // public UserArea(String name, UserNode[] userNode){       
    //     this.reqQuantity = 0;
    //     this.reqPressure = 0;
    //     this.name = name;      
    //     for(int i = 0; i < userNode.length; i++){
    //         this.reqQuantity += userNode[i].reqQuantity;
    //         this.reqPressure += userNode[i].reqPressure;
    //         this.userAreaList.add(userNode[i]);
    //         this.userAreaMap.put(userNode[i].id, userNode[i]);
    //     }
    //     System.out.printf("UserArea %s has been built (qC=%s, pN=%s , userNum=%s) %n",name, reqQuantity, reqPressure, userAreaList.size());  
    // }
    public void setUserAreaList(UserNode[] userNode) {
        for(int i = 0; i < userNode.length; i++){
            this.userAreaList.add(userNode[i]);
        }
    }
    public List<UserNode> getUserAreaList() {
        return userAreaList;
    }
    public void setreqQuantity() {
        this.reqQuantity = 0;
        for(int i = 0; i < this.userAreaList.size(); i++){        
            this.reqQuantity += this.userAreaList.get(i).reqQuantity;
        }
    }
    public void setreqPressure() {
        this.reqPressure = 0;
        for(int i = 0; i < this.userAreaList.size(); i++){        
            this.reqPressure += this.userAreaList.get(i).reqPressure;
        }
    }
    public void setUserAreaMap() {
        for(int i = 0; i < this.userAreaList.size(); i++){        
            this.userAreaMap.put(this.userAreaList.get(i).name, this.userAreaList.get(i));
        }
    }
}
