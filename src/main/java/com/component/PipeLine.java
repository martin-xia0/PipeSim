package com.component;

//直管段，包含直管段的各项物理属性（材质，直径，长度，绝对粗糙度）
public class PipeLine extends Component {
    int material;
    double diameter;
	double length;
	double delta = calDelta(material);
	
	// public PipeLine(){
    // 	this.material = 1;
    //   	this.diameter = 0.2;
    //   	this.length = 1000;     
    //   	System.out.printf("defult pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
    // }
    // public PipeLine(int material, double diameter, double length){      
    //   	this.material = material;
    //   	this.diameter = diameter;
    //   	this.length = length;
    //   	System.out.printf("pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
	// }
	
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
	public void setMaterial(int material) {
		this.material = material;
	}
	public int getMaterial() {
		return material;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	public double getDiameter() {
		return diameter;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getLength() {
		return length;
	}
	public void setDelta() {
		this.delta = calDelta(this.material);
	}
	public double getDelta() {
		return delta;
	}
}
  