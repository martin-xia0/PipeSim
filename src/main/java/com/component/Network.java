package com.component;
import java.util.*;
/*
branch 
intial pressure
total quantity
*/
public class Network{
  public List<Component> network = new ArrayList<Component>();
  public double iniPressure;
  public double iniQuantity;
  public LocalEnvironment networkEnvironment;
  
  public void setIniPressure(FluidModel model) {
    this.iniPressure = model.iniPressure;
  }
  public void setIniQuantity(FluidModel model) {
    this.iniQuantity = model.iniQuantity;
  }
  // public Network(){
  //   System.out.printf("please add pipes and nodes %n");
  // }
  // public Network(Branch[] branchlist){
  //   for(int i = 0; i < branchlist.length; i++){
  //     this.network.add(branchlist[i]);
  //   System.out.printf("Network with %s pipes has been built %n", branchlist.length);
  //   }
  // }

  public double getHeadLossDW(Component component, Double beginQuantity) {
    double constant = -1;
    double velocity = -1;
    if(component.getGeneralType() == 1){
      PipeLine pipeLine = (PipeLine)component;
      velocity = 4 * beginQuantity / (pipeLine.diameter * pipeLine.diameter * Math.PI);
      double n = pipeLine.delta/pipeLine.diameter;	
      double re = velocity*pipeLine.delta / this.networkEnvironment.getWateKinematicViscosity();
      double lambda = 0;
      if (re<2300){
        lambda = 64/re; 
      }else if (re>=2300 && re<=4000){
        lambda = -1; 
      } else if (n<=0.0008 && re>4000 && re<=10*Math.pow(n,-1)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
      }else if (n<=0.0008 && re>10*Math.pow(n,-1) && re<=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
      }else if (n>0.0008 && re>4000 && re<=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
      }else if (re>=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
      }
      constant = (lambda*pipeLine.length/pipeLine.diameter);
    }else if(component.getGeneralType() == 2){
      PipeNode pipeNode = (PipeNode) component;
      velocity = 4 * beginQuantity / (pipeNode.diameter * pipeNode.diameter * Math.PI);
      constant = pipeNode.zeta;
    }
    double headLoss = constant*(Math.pow(velocity,2))/(2*this.networkEnvironment.getGravitationalAcceleration()); 
    return headLoss;
  }

  public double getTotalHeadLoss(){
    double totalheadLoss = 0;
    return totalheadLoss;
  }

  //此处设计递归
  public double getPressure(double beginPressure, Component component){
    double endPressure = -1;
    endPressure = beginPressure - getHeadLossDW(component, beginQuantity);
    return endPressure;
  }

  public void setNetworkEnvironment(LocalEnvironment networkEnvironment) {
    this.networkEnvironment = networkEnvironment;
  }
  public LocalEnvironment getNetworkEnvironment() {
    return networkEnvironment;
  }
}
