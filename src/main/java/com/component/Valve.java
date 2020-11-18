package com.component;

public class Valve extends Node{
    
    static int nodeType = 2;

    public Valve(){ 
        this.material = -1;
        this.diameter = -1;
        this.zeta = -1; 
        System.out.printf("defult Valve has been built (material=%s, diameter=%s) %n", material, diameter);
    }
    public Valve(int material, double diameter){  
        this.material = material;
        this.diameter = diameter;
        this.zeta = calZeta(material, diameter);
        System.out.printf("Valve has been built (material=%s, diameter=%s) %n", material, diameter);
    }
    public static double calZeta(int material, double diameter){        
        double zeta = -1;
        int diameter_mm = (int)(diameter*1000); 
        if(material == 1){
            switch (diameter_mm){
                case 100:	zeta = 0.01;	break;
                case 200:	zeta = 0.02;	break;
                case 300:	zeta = 0.03;	break;
                case 400:	zeta = 0.04;	break;
                default:	break;           
            }
        }else if (material == 2){
            switch (diameter_mm) {
                case 100:	zeta = 0.02;	break;
                case 200:	zeta = 0.04;	break;
                case 300:	zeta = 0.06;	break;
                case 400:	zeta = 0.08;	break;
                default:	break;
            }
        }return zeta;      
    }
}
