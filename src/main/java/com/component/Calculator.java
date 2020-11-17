package com.component;

public class Calculator {
    public static double totalHeadloss(Network network0, Fluid fluid0){
        
        double hftotal = 0;

        double g = Network.GRAVITATIONAL_ACCELERATION;      
        double t = Network.TEMPERATURE;
        //double rho = Network.DENSITY;
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
            double hf = calHf_DW(lambda, v, l, d, g);

            hftotal += hf;
        }
        return hftotal;
    }

    public static double calHf_DW(double lambda, double v, double l, double d, double g){
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

	public static double calNu(double t){
		double nu = 0.000001775/(1+0.0337*t+0.000221*t*t);
		return nu;
    }
    
    public static double calDelta(int material){
        double delta = -1;
        switch(material){
            case 1: delta = 0.000001;  break;
            case 2: delta = 0.002;  break;
            case 3: delta = 0.003;  break;
            case 4: delta = 0.004;  break;
        }
        return delta;
    }

}

