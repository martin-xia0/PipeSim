package com.component;



public class Network{
  
  static double GRAVITATIONAL_ACCELERATION = 9.8;
  static int TEMPERATURE = 25;
  
  Pipe[] pipelist;
  Node[] nodelist;

  public Network(){
    System.out.printf("please add pipes and nodes %n");
  }

  public Network(Pipe[] pipelist){
    this.pipelist = pipelist;
    this.nodelist = null;
    System.out.printf("Network with %s pipes has been built %n", pipelist.length);
  }

  public Network(Pipe[] pipelist, Node[] nodelist){
    this.pipelist = pipelist;
    this.nodelist = nodelist;
    Pipe pipe1 = new Pip();

    System.out.printf("Network with %s pipes and %s nodes has been built %n", pipelist.length, pipelist.length);
  }


  public double getHeadLoss() {
    return 0.0;
  }

  public void inputData(){
    // hahah
  }
}