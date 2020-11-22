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
  public double totalQ;
  public void setIniPressure(FluidModel model) {
    this.iniPressure = model.iniPressure;
  }
  public Network(){
    System.out.printf("please add pipes and nodes %n");
  }
  public Network(Branch[] branchlist){
    for(int i = 0; i < branchlist.length; i++){
      this.network.add(branchlist[i]);
    System.out.printf("Network with %s pipes has been built %n", branchlist.length);
    }
  }
  public void setTotalQ(double totalQ) {
    this.totalQ = totalQ;
  }
  public double getHeadLossDW(PipeNode node, PipeLine line, FluidModel fluidModel,LocalEnvironment environment){     
    double constant;
    double velocity = 4*totalQ/(node.diameter*node.diameter*Math.PI);   
    if(HF){
      double n = line.delta/line.diameter;	
      double re = velocity*line.delta / environment.getWateKinematicViscosity();
      int rejudge = 0;
      double lambda = 0;
      if (re<2300){
        lambda = 64/re; 
        break;
      }else if (re>=2300 && re<=4000){
        lambda = -1; 
        break;
      } else if (n<=0.0008 && re>4000 && re<=10*Math.pow(n,-1)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
        break;
      }else if (n<=0.0008 && re>10*Math.pow(n,-1) && re<=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
        break;	
      }else if (n>0.0008 && re>4000 && re<=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
        break;
      }else if (re>=576.12*Math.pow(n,-1.119)){
        lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)); 
        break;
      }
      constant = (lambda*line.length/line.diameter);
    }else if(HJ){
      constant = node.zeta;
    }
    double headLoss = constant*(Math.pow(velocity,2))/(2*environment.getGravitationalAcceleration()); 
    return headLoss;
  }
  public double getTotalHeadLoss(){
    double totalheadLoss = 0;
    return totalheadLoss;
  }
}
