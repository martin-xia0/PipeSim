package com.component;

class Network{
  
  static double GRAVITATIONAL_ACCELERATION = 9.8;
  static int TEMPERATURE = 25;
  
  Pipe[] pipelist;
  Node[] nodelist;

  public Network(){
    System.out.printf("please add pipes and nodes\n");
  }

  public Network(Pipe[] pipelist){
    this.pipelist = pipelist;
    this.nodelist = null;
    System.out.printf("Network with "+ pipelist.length + " pipes has been built\n");
  }

  public Network(Pipe[] pipelist, Node[] nodelist){
    this.pipelist = pipelist;
    this.nodelist = nodelist;
    System.out.printf("Network with "+ pipelist.length + " pipes and "+ nodelist.length + " nodes has been built\n");
  }

  
}

class Pipe{
  
  int pipe_material;
  double pipe_diameter;
  double pipe_length;

  public Pipe(){
        
    this.pipe_material = 1;
    this.pipe_diameter = 0.2;
    this.pipe_length = 1000;
    
    System.out.printf("defult pipe has been built (material=%s, diameter=%s, length=%s)\n",pipe_material, pipe_diameter, pipe_length);
  }

  public Pipe(int pipe_material, double pipe_diameter, double pipe_length){
    
    this.pipe_material = pipe_material;
    this.pipe_diameter = pipe_diameter;
    this.pipe_length = pipe_length;
    
    System.out.printf("pipe has been built (material=%s, diameter=%s, length=%s)\n",pipe_material, pipe_diameter, pipe_length);
  }
}

class Node{
  
  int node_material;
  double node_diameter;
  int node_type;  
  
  public Node(){
    
    this.node_material = 1;
    this.node_diameter = 0.2;
    this.node_type = 1;
    
    System.out.printf("defult node has been built (material=%s, diameter=%s, type=%s)\n", node_material, node_diameter, node_type);
  }

  public Node(int node_material, double node_diameter, int node_type){
    
    this.node_material = node_material;
    this.node_diameter = node_diameter;
    this.node_type = node_type;

    System.out.printf("node has been built (material=%s, diameter=%s, type=%s)\n", node_material, node_diameter, node_type);
  }
}

