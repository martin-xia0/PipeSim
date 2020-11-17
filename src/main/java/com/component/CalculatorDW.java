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

