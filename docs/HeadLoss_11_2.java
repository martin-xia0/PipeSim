/*
	利用 达西－魏斯巴赫公式 Darcy-Weisbach Formula（简称DWformula） 计算沿程水头损失
	2020.11.2 更新圆管满流湍流阻力平方区沿程水头损失计算
	2020.11.2 更新圆管满流层流区沿程水头损失计算
	*/

public class HeadLoss{
	public static void main(String[] args) {

/* 
	测试用数据
	*/		
		double t = 10;
		double rho = 1000;
		double g = 9.8;
		double d = 0.300;
		double q = 0.05;		
		double l = 1000;
		double delta = 0.001;

/*
	计算部分 分别计算 平均流速v 相对粗糙度n 运动粘度mu 雷诺数综合remix（包括雷诺数和流态判别） 沿程阻力系数lambda 沿程水头损失hf
	*/			
		double v = 4*q/(d*d*Math.PI);
		double n = delta/d;
		double mu1 = calMu(t);
		double[] remix1 = calReMix(rho, v, d, mu1);
		double lambda1 = calLambda(remix1, n);
		double hf = dWFomula(lambda1, v, l, d, g);

/*
	测试反馈部分
	*/		
		System.out.println("v" + " = " + v);
		System.out.println("mu" + " = " + mu1);
		System.out.println("re" + " = " + remix1[0]);
		System.out.println("lambda" + " = " + lambda1);
		System.out.println("hf" + " = " + hf);
	}

/*
	沿程水头损失hf的计算，采用DWFomula
	*/
	public static double dWFomula(double lambda, double v, double l, double d, double g){
		double hf =  lambda*(l*v*v/(2*d*g));
		return hf;
	}



/*
	沿程水头损失系数lambda的计算，层流区采用理论公式，湍流区采用巴尔公式
	*/
	public static double calLambda(double[] remix, double n){
		double re = remix[0];
		double rejudge = remix[1];	
		double lambda = 0;

		if(rejudge == 1){
			lambda = 64/re;
		}else{
			lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));
		};			
		return lambda;
	}

/*
	雷诺数re的计算，采用雷诺数通常计算公式
	2300为层流紊流分界，紊流细分待完善
	11.2 层流判别已添加
	*/
	public static double[] calReMix(double rho, double v, double d, double mu){
		
		double[] remix = new double[2];
		double re = v*d/mu;
		double rejudge = 0;

		if (re < 2300) {
			rejudge = 1;			
		}else{
			rejudge = 5;
		};
		
		remix[0]=re;
		remix[1]=rejudge;

		return remix;
	}


/*
	流体的运动粘度mu的计算，采用水的运动粘度经验公式，仅与温度t相关
	*/
	public static double calMu(double t){
		double mu = 0.000001775/(1+0.0337*t+0.000221*t*t);
		return mu;
	}

}