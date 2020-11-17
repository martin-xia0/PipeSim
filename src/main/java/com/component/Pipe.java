package com.component;


class Pipe{

    int material;
    double diameter;
    double length;
    double nu;

    public Pipe(){
          
      this.material = 1;
      this.diameter = 0.2;
      this.length = 1000;
      this.nu = 000001003;
      
      System.out.printf("defult pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
    }
  
    public Pipe(int material, double diameter, double length, int t){
      
      this.material = material;
      this.diameter = diameter;
      this.length = length;
      this.nu = this.calNu(t);
      
      System.out.printf("pipe has been built (material=%s, diameter=%s, length=%s) %n",material, diameter, length);
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
    }
    
    public static double calDelta(int material){
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
  