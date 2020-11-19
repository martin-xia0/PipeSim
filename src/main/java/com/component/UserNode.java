package com.component;

//用水节点，包含用水节点基本参数（类型，名称，流量消耗，压力需求）
public class UserNode extends Component{
    public String type;
    public double quantityConsume;
    public double pressureNeed;
    public UserNode(){
        this.type = null;
        this.id = null;
        this.quantityConsume = -1;
        this.pressureNeed = -1;
    }
    public UserNode(String type, String id, double quantityConsume){
        this.type = type;
        this.id = id;
        this.quantityConsume = quantityConsume;
        this.pressureNeed = 0;
        System.out.printf("%s UserNode %s has been built (qC = %s) %n",type, id, quantityConsume);
    }
    public UserNode(String type, String id, double quantityConsume, double pressureNeed){
        this.type = type;
        this.id = id;
        this.quantityConsume = quantityConsume;
        this.pressureNeed = pressureNeed;
        System.out.printf("%s UserNode %s has been built (qC = %s, pN= %s) %n",type, id, quantityConsume, pressureNeed);
    }
}