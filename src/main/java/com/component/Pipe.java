package com.component;

public class Pipe{
    int material;
    double diameter;
	double length;
	double delta = calDelta(material);
	
	public Pipe(){
    	this.material = 1;
      	this.diameter = 0.2;
      	this.length = 1000;     
      	System.out.printf("defult pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
    }
    public Pipe(int material, double diameter, double length){      
      	this.material = material;
      	this.diameter = diameter;
      	this.length = length;
      	System.out.printf("pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
	}
	
	public double calDelta(int material){
		double delta = -1;
		switch(material){
			case 1: delta = 0.000005;	break;//塑料
			case 2: delta = 0.000250;	break;//新铸铁
			case 3: delta = 0.002000;	break;//旧铸铁
			case 4: delta = 0.000100;	break;//新钢铁
			case 5: delta = 0.000200;	break;//旧钢铁
			case 6:	delta = 0.000200;	break;//水泥
		}
		return delta;
	}
}
  