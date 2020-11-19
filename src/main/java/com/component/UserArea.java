package com.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//用水区域，用水节点的集合，包含用水区域的基本参数（区域代号,区域内用水节点列表，区域总流量消耗，区域总压力需求）
public class UserArea extends UserNode{

    public UserArea(){
        this.id = null;
        this.quantityConsume = -1;
    }
    public UserArea(String id, UserNode[] userNode){       
        this.quantityConsume = 0;
        this.pressureNeed = 0;
        this.id = id;      
        ArrayList<UserNode> userAreaList = new ArrayList<>();
        Map<String, UserNode> userAreaMap = new HashMap<String, UserNode>(); 
        for(int i = 0; i < userNode.length; i++){
            this.quantityConsume += userNode[i].quantityConsume;
            this.pressureNeed += userNode[i].pressureNeed;
            userAreaList.add(userNode[i]);
            userAreaMap.put(userNode[i].id, userNode[i]);
        }
        System.out.printf("UserArea %s has been built (qC=%s, pN=%s , userNum=%s) %n",id, quantityConsume, pressureNeed, userAreaList.size());  
    }
}
