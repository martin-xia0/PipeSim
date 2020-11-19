package com.component;

//用水节点，包含用水节点基本参数（类型，名称，流量消耗，压力需求）
public class UserNode extends Component{
    public String type;
    public double quantityConsume;
    public double pressureNeed;
    public String name;
    
    public UserNode(){
        this.type = null;
        this.name = null;
        this.quantityConsume = -1;
        this.pressureNeed = -1;
    }
    public UserNode(String type, String name, double quantityConsume){
        this.type = type;
        this.name = name;
        this.quantityConsume = quantityConsume;
        this.pressureNeed = 0;
        System.out.printf("%s UserNode %s has been built (qC = %s) %n",type, name, quantityConsume);
    }
    public UserNode(String type, String name, double quantityConsume, double pressureNeed){
        this.type = type;
        this.name = name;
        this.quantityConsume = quantityConsume;
        this.pressureNeed = pressureNeed;
        System.out.printf("%s UserNode %s has been built (qC = %s, pN= %s) %n",type, name, quantityConsume, pressureNeed);
    }
}