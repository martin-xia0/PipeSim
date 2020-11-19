package com.component;

//流体相关（可取消，思考中）
//可在network中设置出厂水压，用水量和需求水压应当在用户类中
//或保留该类，作为后续开发压力模型和压力分析的基本类（因为可以建立不同的Fluid模型，直接替换）
public class Fluid extends Component{
    
    private double quantity;
    private double pressure;

    public Fluid(){
        this.id = null;
        this.quantity = -1;
    }
    public Fluid(double quantity){
        this.id = "defult";
        this.quantity = quantity;
        System.out.println("Fluid model built");  
    }    
    public Fluid(String modelName,double quantity){
        this.id = modelName;
        this.quantity = quantity;
        System.out.println("Fluid model built");  
    }
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
    public double getPressure() {
        return pressure;
    }
}