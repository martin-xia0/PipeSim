package com.component;

public class Node {
    int material;
    double diameter;
    int nodeType;  
    
    public Node(){
      
      this.material = 1;
      this.diameter = 0.2;
      this.nodeType = 1;
      
      System.out.printf("defult node has been built (material=%s, diameter=%s, type=%s) %n", material, diameter, nodeType);
    }
  
    public Node(int material, double diameter, int nodeType){
      
      this.material = material;
      this.diameter = diameter;
      this.nodeType = nodeType;
  
      System.out.printf("node has been built (material=%s, diameter=%s, type=%s) %n", material, diameter, nodeType);
    }
	public static double calHj(double zeta, double v, double g){
        double hj = zeta*v*v/(2*g); 
            return hj;
        }
    
        public static double calZeta(Node node){
            int material = node.material;
            int diameter_mm = (int)node.diameter*1000;
            int type =  node.nodeType;
            double zeta = -1;
            
            if (type == 1){
                if(material == 1){
                    switch (diameter_mm){
                        case 100:	zeta = 0.01;	break;
                        case 200:	zeta = 0.01;	break;
                        case 300:	zeta = 0.01;	break;
                        case 400:	zeta = 0.01;	break;
                        default:	break;
                    }
                }else if (material == 2){
                    switch (diameter_mm) {
                        case 100:	zeta = 0.02;	break;
                        case 200:	zeta = 0.03;	break;
                        case 300:	zeta = 0.04;	break;
                        case 400:	zeta = 0.05;	break;
                        default:	break;
                    }
                }
            }else if (type ==2){
                if(material == 1){
                    switch (diameter_mm){
                        case 100:	zeta = 0.01;	break;
                        case 200:	zeta = 0.01;	break;
                        case 300:	zeta = 0.01;	break;
                        case 400:	zeta = 0.01;	break;
                        default:	break;
                    }
                }else if (material == 2){
                    switch (diameter_mm){
                        case 100:	zeta = 0.03;	break;
                        case 200:	zeta = 0.04;	break;
                        case 300:	zeta = 0.01;	break;
                        case 400:	zeta = 0.01;	break;
                        default:	break;
                    }
                }
            }
            return zeta;
        }
    
}
  
  