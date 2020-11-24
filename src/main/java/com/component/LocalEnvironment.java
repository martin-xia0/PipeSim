package com.component;

//环境配置，用于配置温度和当地重力加速度（以及后续可能会添加的环境相关的参数），运动粘度计算可放在这部分
public class LocalEnvironment extends Component{
    public int temperature;
    public double gravitationalAcceleration;
    public double wateKinematicViscosity;

    public LocalEnvironment(){
        temperature = -1;
        gravitationalAcceleration = -1;
        wateKinematicViscosity = -1;
        setGeneralType(0);
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        //System.out.printf("温度为%s摄氏度 %n" ,getTemperature());
    }
    public int getTemperature() {
        return temperature;
    }

    public void setGravitationalAcceleration(double gravitationalAcceleration) {
        this.gravitationalAcceleration = gravitationalAcceleration;
        //System.out.printf("当地重力加速度为%s %n" ,getGravitationalAcceleration());
    }
    public double getGravitationalAcceleration() {
        return gravitationalAcceleration;
    }
    
    public void setWateKinematicViscosity() {
        this.wateKinematicViscosity = calNu(this.temperature);
        //System.out.printf("运动粘度为%s %n" ,getWateKinematicViscosity());
    }
    public double getWateKinematicViscosity() {
        return wateKinematicViscosity;
    }
    
    public double calNu(int t){
        double nu = -1;
        switch(t){
         case 5: nu = 0.000001519; break;
         case 10:nu = 0.000001306; break;
         case 15:nu = 0.000001139; break;
         case 20:nu = 0.000001003; break;
         case 25:nu = 0.000000893; break;
         case 30:nu = 0.000000800; break;
         case 35:nu = 0.000000722; break;
         case 40:nu = 0.000000658; break;
         default:nu = 0.000001775/(1+0.0337*t+0.000221*t*t); break;
        }
        return nu;
    }
}
