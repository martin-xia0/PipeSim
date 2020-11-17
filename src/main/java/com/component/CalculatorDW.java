package com.component;

public class CalculatorDW {
    public static double totalHeadloss(Network network0, Fluid fluid0){
        
		double hftotal = 0;
		double hjtotal = 0;

        double g = Network.GRAVITATIONAL_ACCELERATION;      
		int t = Network.TEMPERATURE;
		
        double q = fluid0.getQuantity();
		double nu = calNu(t);

        for(int i = 0; i < network0.pipelist.length; i++){
            
            double d = network0.pipelist[i].pipe_diameter;
            double l = network0.pipelist[i].pipe_length;
            double delta = calDelta(network0.pipelist[i].pipe_material);
            
            double v = 4*q/(d*d*Math.PI);
		    double n = delta/d;		    
		    double re = calRe(v, d, nu);
			
			double lambda = calLambda(re, n);
            double hf = calHf(lambda, v, l, d, g);
            hftotal += hf;
		}
		for(int i = 0; i < network0.nodelist.length; i++){
            
            double d = network0.nodelist[i].node_diameter;           
			
			double v = 4*q/(d*d*Math.PI);	    
			
			double zeta = calZeta(network0.nodelist[i]);
			double hj = calHj(zeta, v, g);
            hjtotal += hj;
		}
		double hw = hftotal + hjtotal;
		return hw;
	}

    public static double calHf(double lambda, double v, double l, double d, double g){
		double hf =  lambda*(l*v*v/(2*d*g));
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

	public static double calRe(double v, double d, double nu){	
		double re = v*d/nu;
		return re;
	}

	public static double calNu(int t){
		double nu = -1;
		switch(t){
			case 5:	nu = 0.000001519;	break;
			case 10:nu = 0.000001306;	break;
			case 15:nu = 0.000001139;	break;
			case 20:nu = 0.000001003;	break;
			case 25:nu = 0.000000893;	break;
			case 30:nu = 0.000000800;	break;
			case 35:nu = 0.000000722;	break;
			case 40:nu = 0.000000658;	break;
			default:nu = 0.000001775/(1+0.0337*t+0.000221*t*t);	break;
		}
		return nu;
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

	public static double calHj(double zeta, double v, double g){
		double hj = zeta*v*v/(2*g); 
		return hj;
	}

	public static double calZeta(Node node){
		int material = node.node_material;
		int diameter_mm = (int)node.node_diameter*1000;
		int type =  node.node_type;
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
					case 100:	zeta = 0.01;	break;
					case 200:	zeta = 0.01;	break;
					case 300:	zeta = 0.01;	break;
					case 400:	zeta = 0.01;	break;
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
					case 100:	zeta = 0.01;	break;
					case 200:	zeta = 0.01;	break;
					case 300:	zeta = 0.01;	break;
					case 400:	zeta = 0.01;	break;
					default:	break;
				}
			}
		}
		return zeta;
	}
}

