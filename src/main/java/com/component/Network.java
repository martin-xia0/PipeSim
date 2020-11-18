package com.component;

import java.util.*;


//暂时没有想好
public class Network{
  List<Component> network = new ArrayList<Component>();
  
  
  Pipe[] pipelist;
  Node[] nodelist;

  public Network(){
    // parse 
    for (Component c: ??){
      network.add(c);
    }
    System.out.printf("please add pipes and nodes %n");
  }
  // 从头到尾
  // 分叉？？

  public Network(Pipe[] pipelist){
    this.pipelist = pipelist;
    this.nodelist = null;
    System.out.printf("Network with %s pipes has been built %n", pipelist.length);
  }

  public Network(Pipe[] pipelist, Node[] nodelist){
    this.pipelist = pipelist;
    this.nodelist = nodelist;
    Pipe pipe1 = new Pipe();

    System.out.printf("Network with %s pipes and %s nodes has been built %n", pipelist.length, pipelist.length);
  }

  public double getQuantity() {
    //  water use in all UserAreas

  }


  public double getHeadLoss() {    
    double totalHeadLoss;
    for (Component c: network) {
      // totalHeadLoss += c.getHeadLoss();
    }
    return totalHeadLoss;
  }

  public void inputData(){
    // hahah
  }
}

public class CalculatorDW {
  public static double totalHeadloss(Network network0, Fluid fluid0){
      
  double hftotal = 0;
  double hjtotal = 0;
  
      double q = fluid0.getQuantity();
  double nu = calNu(t);

      for(int i = 0; i < network0.pipelist.length; i++){
          
          double d = network0.pipelist[i].diameter;
          double l = network0.pipelist[i].length;
          double delta = calDelta(network0.pipelist[i].material);
          
          double v = 4*q/(d*d*Math.PI);
      double n = delta/d;		    
      double re = calRe(v, d, nu);
    
    double lambda = calLambda(re, n);
          double hf = calHf(lambda, v, l, d, g);
          hftotal += hf;
  }
  for(int i = 0; i < network0.nodelist.length; i++){
          
          double d = network0.nodelist[i].diameter;           
    
    double v = 4*q/(d*d*Math.PI);	    
    
    double zeta = calZeta(network0.nodelist[i]);
    double hj = calHj(zeta, v, g);
          hjtotal += hj;
  }
  double hw = hftotal + hjtotal;
  return hw;
}



}

public double calHf(double q, double g){
double delta = calDelta(this.material);

double v = 4*q / (Math.pow(diameter,2)*Math.PI);
double re = v*diameter / this.nu;

double lambda = calLambda(re, delta/diameter);
double hf = lambda*this.length*(Math.pow(v, 2)) / (2*this.diameter*g);

return hf;
}

public static double calLambda(double re, double n){
int rejudge = 0;
double lambda = 0;

if (re<2300){
  rejudge = 1;
}else if (re>=2300 && re<=4000){
  rejudge = 2;
} else if (n<=0.0008 && re>4000 && re<=10*Math.pow(n,-1)){
  rejudge = 3;
}else if (n<=0.0008 && re>10*Math.pow(n,-1) && re<=576.12*Math.pow(n,-1.119)){
  rejudge = 4;		
}else if (n>0.0008 && re>4000 && re<=576.12*Math.pow(n,-1.119)){
  rejudge = 4;
}else if (re>=576.12*Math.pow(n,-1.119)){
  rejudge = 5;
}

switch(rejudge){
  case 1: lambda = 64/re; break;
  case 2: lambda = -1;    break; //过渡区无法计算，返回错误值
  case 3: lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));   break;
  case 4: lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));   break;
  case 5: lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));   break;		
}
return lambda;

}	public static double calHj(double zeta, double v, double g){
double hj = zeta*v*v/(2*g); 
  return hj;
}  
