package com.component;

//用水节点，包含用水节点基本参数（类型，名称，流量消耗，压力需求）
public class UserNode extends Component{
    public String type;
    public double reqQuantity;
    public double reqPressure;
    
    // public UserNode(){
    //     this.type = null;
    //     this.name = null;
    //     this.reqQuantity = -1;
    //     this.reqPressure = -1;
    // }
    // public UserNode(String type, String name, double reqQuantity){
    //     this.type = type;
    //     this.name = name;
    //     this.reqQuantity = reqQuantity;
    //     this.reqPressure = 0;
    //     System.out.printf("%s UserNode %s has been built (qC = %s) %n",type, name, reqQuantity);
    // }
    // public UserNode(String type, String name, double reqQuantity, double reqPressure){
    //     this.type = type;
    //     this.name = name;
    //     this.reqQuantity = reqQuantity;
    //     this.reqPressure = reqPressure;
    //     System.out.printf("%s UserNode %s has been built (qC = %s, pN= %s) %n",type, name, reqQuantity, reqPressure);
    // }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setReqQuantity(double reqQuantity) {
        this.reqQuantity = reqQuantity;
    }
    public double getReqQuantity() {
        return reqQuantity;
    }

    public void setReqPressure(double reqPressure) {
        this.reqPressure = reqPressure;
    }
    public double getReqPressure() {
        return reqPressure;
    }
}