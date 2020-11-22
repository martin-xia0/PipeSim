package com.main;

import java.util.*;
import com.component.*;

public class test {
    public static void main(String[] args) {
        
        System.out.println("==================================");
        System.out.println("work begin");
        
        //环境配置
        System.out.println("------------环境配置---------------");
        LocalEnvironment sanshuiSpring = new LocalEnvironment();
        sanshuiSpring.setGravitationalAcceleration(9.8);
        sanshuiSpring.setTemperature(20);
        //管道元素建立
        System.out.println("------------管道元素建立------------");
        PipeLine pipe1 = new PipeLine(1,0.3,5000);
        PipeLine pipe2 = new PipeLine(2,0.3,1000);
        PipeLine pipe3 = new PipeLine(1,0.2,500);
        Valve valve1 = new Valve(2,0.4);
        Valve valve2 = new Valve(1,0.2);
        Elbow elbow1 = new Elbow(1,0.2);
        Elbow elbow2 = new Elbow(2,0.3);
        //流体建立（待商榷）
        System.out.println("----------流体建立（待商榷）---------");
        //用水节点建立
        System.out.println("------------用水节点建立-------------");
        UserNode userNode1 = new UserNode("family","zhangsan",0.15);
        UserNode userNode2 = new UserNode("family","lisi",0.2);
        UserNode userNode3 = new UserNode("factory","laowang BBQ",2 , 16);
        //用水区域建立
        System.out.println("------------用水区域建立--------------");
        UserArea userArea1 = new UserArea("abc xiaoqu",new UserNode[]{userNode1,userNode2,userNode3});
        
        System.out.println("=====================================");
        System.out.println("work finished");
        
        
        
    }
}
