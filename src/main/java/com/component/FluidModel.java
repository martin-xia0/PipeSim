package com.component;

//流体相关（可取消，思考中）
//可在network中设置出厂水压，用水量和需求水压应当在用户类中
//或保留该类，作为后续开发压力模型和压力分析的基本类（因为可以建立不同的Fluid模型，直接替换）
public class FluidModel extends Component{
    
    public double iniQuantity;
    public double reqQuantity;
    public double iniPressure;
    public double reqPressure;
    // public FluidModel() {
    //     this.name = null;
    //     //this.quantity = -1;
    // }
    // public FluidModel(double quantity) {
    //     this.name = "defult";
    //     //this.quantity = quantity;
    //     System.out.println("Fluid model built");  
    // }    
    // public FluidModel(String modelName, double quantity) {
    //     this.name = modelName;
    //     //this.quantity = quantity;
    //     System.out.println("Fluid model built");  
    // }
    public void setIniPressure(double iniPressure) {
        this.iniPressure = iniPressure;
    }
    public double getIniPressure() {
        return iniPressure;
    }

    public void setReqPressure(double reqPressure) {
        this.reqPressure = reqPressure;
    }
    public double getReqPressure() {
        return reqPressure;
    }

    public void setIniQuantity(double iniQuantity) {
        this.iniQuantity = iniQuantity;
    }
    public double getIniQuantity() {
        return iniQuantity;
    }
    
    public void setReqQuantity(double reqQuantity) {
        this.reqQuantity = reqQuantity;
    }
    public double getReqQuantity() {
        return reqQuantity;
    }
}