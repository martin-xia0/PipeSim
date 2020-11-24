package com.main;

import java.util.*;
import com.component.*;

public class test {
    public static void main(String[] args) {
        
        System.out.println("==================================");
        System.out.println("work begin");
        
        //环境配置
        //System.out.println("环境配置开始");
        LocalEnvironment testmodel = new LocalEnvironment();
        testmodel.setId(1);
        testmodel.setName("狼牙镇春季");
        testmodel.setGravitationalAcceleration(9.8);
        testmodel.setTemperature(20);
        testmodel.setWateKinematicViscosity();
        System.out.println("环境配置完成");
        //管道管段建立
        //System.out.println("管段建立开始");
        PipeLine[] pipelines = new PipeLine[30];
        for(int i = 0; i < 8; i++){
            pipelines[i] = new PipeLine();
            pipelines[i].setId(i);
            pipelines[i].setName("300管道" + (i+1));
            pipelines[i].setMaterial(1);
            pipelines[i].setDiameter(0.3);
        }
        for (int i = 8; i < 21; i++) {
            pipelines[i] = new PipeLine();
            pipelines[i].setId(i);
            pipelines[i].setName("200管道" + (i-7));
            pipelines[i].setMaterial(1);
            pipelines[i].setDiameter(0.2);
        }
        for (int i = 21; i < 30; i++) {
            pipelines[i] = new PipeLine();
            pipelines[i].setId(i);
            pipelines[i].setName("100管道" + (i-20));
            pipelines[i].setMaterial(1);
            pipelines[i].setDiameter(0.1);
        }
        //300
        pipelines[0].setLength(250);//阀门1
        pipelines[1].setLength(250);//三通1
        pipelines[2].setLength(500);//三通2
        pipelines[3].setLength(500);//阀门2
        pipelines[4].setLength(500);//弯头1
        pipelines[5].setLength(250);//三通3
        pipelines[6].setLength(400);//断大
        pipelines[7].setLength(300);//断小
        //200
        pipelines[8].setLength(500);//弯头2
        pipelines[9].setLength(500);//三通4
        pipelines[10].setLength(200);//麦当劳
        pipelines[11].setLength(100);//三通5
        pipelines[12].setLength(150);//弯头3
        pipelines[13].setLength(150);//小区
        pipelines[14].setLength(150);//弯头4
        pipelines[15].setLength(100);//超市
        pipelines[16].setLength(300);//弯头5
        pipelines[17].setLength(200);//三通6
        pipelines[18].setLength(100);//三通7 
        pipelines[19].setLength(100);//弯头6
        pipelines[20].setLength(300);//弯头7
        //100
        pipelines[21].setLength(100);//弯头8
        pipelines[22].setLength(50);//赵日天
        pipelines[23].setLength(150);//弯头9
        pipelines[24].setLength(150);//三通8
        pipelines[25].setLength(50);//李杀神
        pipelines[26].setLength(100);//张伟
        pipelines[27].setLength(100);//三通9
        pipelines[28].setLength(100);//王诛魔
        pipelines[29].setLength(150);//刘斩仙
        System.out.println("管段建立完成");
        //弯头建立
        //System.out.println("弯头建立开始");
        Elbow[] elbows = new Elbow[9];
        for(int i = 0; i < 1; i++){
            elbows[i] = new Elbow();
            elbows[i].setId(i);
            elbows[i].setName("300弯头" + (i+1));
            elbows[i].setMaterial(1);
            elbows[i].setDiameter(0.3);
        }
        for (int i = 1; i < 7; i++) {
            elbows[i] = new Elbow();
            elbows[i].setId(i);
            elbows[i].setName("200弯头" + (i));
            elbows[i].setMaterial(1);
            elbows[i].setDiameter(0.2);
        }
        for (int i = 7; i < 9; i++) {
            elbows[i] = new Elbow();
            elbows[i].setId(i);
            elbows[i].setName("100弯头" + (i-6));
            elbows[i].setMaterial(1);
            elbows[i].setDiameter(0.1);
        }
        System.out.println("弯头建立完成");
        //阀门建立
        //System.out.println("阀门建立开始");
        Valve[] valves = new Valve[2];
        valves[0] = new Valve();
        valves[0].setId(0);
        valves[0].setName("300阀门1");
        valves[0].setMaterial(1);
        valves[0].setDiameter(0.3);
        valves[1] = new Valve();
        valves[1].setId(1);
        valves[1].setName("300阀门2");
        valves[1].setMaterial(1);
        valves[1].setDiameter(0.3);
        System.out.println("阀门建立完成");
        //三通建立
        //System.out.println("三通建立开始");
        TriJunction[] triJunctions = new TriJunction[8];
        for(int i = 0; i < 3; i++){
            triJunctions[i] = new TriJunction();
            triJunctions[i].setId(i);
            triJunctions[i].setName("300三通" + (i+1));
            triJunctions[i].setMaterial(1);
            triJunctions[i].setDiameter(0.3);
        }
        for (int i = 3; i < 6; i++) {
            triJunctions[i] = new TriJunction();
            triJunctions[i].setId(i);
            triJunctions[i].setName("200三通" + (i-2));
            triJunctions[i].setMaterial(1);
            triJunctions[i].setDiameter(0.2);
        }
        for (int i = 6; i < 8; i++) {
            triJunctions[i] = new TriJunction();
            triJunctions[i].setId(i);
            triJunctions[i].setName("100三通" + (i-5));
            triJunctions[i].setMaterial(1);
            triJunctions[i].setDiameter(0.1);
        }
        System.out.println("三通建立完成");
        //用水节点建立
        UserNode[] userNodes = new UserNode[10];
        for(int i = 0; i < 5; i++){
            userNodes[i] = new UserNode();
            userNodes[i].setId(i);
            userNodes[i].setUserType("普通居民");
        }
        for(int i = 5; i < 6; i++){
            userNodes[i] = new UserNode();
            userNodes[i].setId(i);
            userNodes[i].setUserType("居民小区");
        }
        for(int i = 6; i < 8; i++){
            userNodes[i] = new UserNode();
            userNodes[i].setId(i);
            userNodes[i].setUserType("商业用水点");
        }
        for(int i = 8; i < 10; i++){
            userNodes[i] = new UserNode();
            userNodes[i].setId(i);
            userNodes[i].setUserType("学校");
        }
        userNodes[0].setName("赵日天");
        userNodes[0].setReqQuantity(2);
        userNodes[1].setName("李杀神");
        userNodes[1].setReqQuantity(2);
        userNodes[2].setName("张伟");
        userNodes[2].setReqQuantity(2);
        userNodes[3].setName("王诛魔");
        userNodes[3].setReqQuantity(2);
        userNodes[4].setName("刘斩仙");
        userNodes[4].setReqQuantity(2);
        
        userNodes[5].setName("狼牙小区");
        userNodes[5].setReqQuantity(10);
        userNodes[6].setName("狼牙超市");
        userNodes[6].setReqQuantity(10);
        userNodes[7].setName("金拱门");
        userNodes[7].setReqQuantity(10);
        
        userNodes[8].setName("断罪小学");
        userNodes[8].setReqQuantity(15);
        userNodes[9].setName("断罪小学附属大学");
        userNodes[9].setReqQuantity(15);
        
        System.out.println("用水节点建立完成");
        //用水区域建立
        UserArea userArea1 = new UserArea();
        userArea1.setUserAreaList(new UserNode[]{userNodes[0],userNodes[1],userNodes[2],userNodes[3],userNodes[4]});
        userArea1.setId(1);
        userArea1.setName("飞虎村");
        userArea1.setUserAreaMap();
        UserArea userArea2 = new UserArea();
        userArea2.setUserAreaList(new UserNode[]{userNodes[5],userNodes[6],userNodes[7]});
        userArea2.setId(2);
        userArea2.setName("狼牙街道");
        userArea2.setUserAreaMap();
        UserArea userArea3 = new UserArea();
        userArea3.setUserAreaList(new UserNode[]{userNodes[8],userNodes[9]});
        userArea3.setId(3);
        userArea3.setName("大学城");
        userArea3.setUserAreaMap();

        System.out.printf("赵日天每小时用%s吨水%n",userArea1.userAreaMap.get("赵日天").getReqQuantity());
        //管道分支创建

        //管网分支点创建
        
        System.out.println("用水区域建立完成");
        System.out.println("work finished");
        System.out.println("=====================================");
    }
}
