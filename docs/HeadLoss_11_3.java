/*
	
	2020.11.2 	更新利用 达西－魏斯巴赫公式 Darcy-Weisbach Formula（简称DWformula） 计算沿程水头损失
				更新圆管满流湍流阻力平方区沿程水头损失计算
			  	更新圆管满流层流区沿程水头损失计算
	2020.11.3 	更新阻力区判别和对应选择沿程水头损失计算公式
			  	更新已知局部水头损失系数情况下局部水头损失的计算
			  	添加大量注释
	*/

import java.util.ArrayList;


public class Network
{

	
	ArrayList {Pipe1, FAMEN}
	HeadLoss()
	FOR OBJ IN 
	irrelavent to v situation
	include

	HeadLoss(v, Q):

}


public class Pipe
{
	SEG1+SGE2+ 
}

public class Pipeseg
// 最小直管微元

public class PipeBend
// 弯头
{

}

public class Valve
// 阀门
{

}

public class Obj
{
	public headLoss()
}

public class HeadLoss{
	
	public static void main(String[] args) {

/* 
	测试用数据 
	温度t 液体密度rho 重力加速度g 管径d 流量q 管道长度l 管壁绝对粗糙度delta 以上单位均采用国际单位制
	*/		
		double t = 10;
		double rho = 1000;
		double g = 9.8;
		double d = 0.300;
		double q = 0.05;		
		double l = 1000;
		double delta = 0.001;

/*
	计算部分 
	分别计算 平均流速v 相对粗糙度n 运动粘度nu 雷诺数re 沿程阻力系数lambda 沿程水头损失hf
	*/			
		double v = 4*q/(d*d*Math.PI);
		double n = delta/d;
		double nu = calNu(t);
		double re = calRe(v, d, nu);
		double lambda = calLambda(re, n);
		double hf = calHf_DW(lambda, v, l, d, g);
		ArrayList<Double> zetalist = (ArrayList<Double>)calZeta();
		double hj = calHj(v, zetalist, g);
		double hw = hf + hj;

/*
	测试反馈部分
	*/		
		System.out.println("平均流速v = " + v);
		System.out.println("运动粘度nu = " + nu);
		System.out.println("雷诺数re = " + re);
		System.out.println("沿程阻力系数lambda = " + lambda);
		System.out.println("沿程水头损失hf = " + hf);
		System.out.println("局部水损系数zeta = " + zetalist);
		System.out.println("局部水头损失hj = " + hj);
		System.out.println("总水头损失hw = " + hw);
	}

/*
	沿程水头损失hf的计算，采用DWFonula
	*/
	public static double calHf_DW(double lambda, double v, double l, double d, double g) {
		
		//公式计算
		double hf =  lambda*(l*v*v/(2*d*g));
		
		//返回沿程水头损失hf
		return hf;
	}

/*
	沿程水头损失系数lambda的计算，层流区采用理论公式，湍流区采用巴尔公式
	11.3 加入穆迪图阻力区判别
	*/
	public static double calLambda(double re, double n) {
		
		//rejdge作为阻力区判别值
		int rejudge = 0;
		double lambda = 0;
		
		//阻力区判别，1为层流区，2为层流向紊流过渡区，3为紊流光滑区，4为紊流过渡区，5为紊流粗糙区
		if (re<2300) {
			rejudge = 1;
		}else if (re>=2300 && re<=4000) {
			rejudge = 2;
		} else if (n<=0.0008 && re>4000 && re<=10*Math.pow(n,-1)) {
			rejudge = 3;
		}else if (n<=0.0008 && re>10*Math.pow(n,-1) && re<=576.12*Math.pow(n,-1.119)) {
			rejudge = 4;		
		}else if (n>0.0008 && re>4000 && re<=576.12*Math.pow(n,-1.119)) {
			rejudge = 4;
		}else if (re>=576.12*Math.pow(n,-1.119)) {
			rejudge = 5;
		}
		
		//根据阻力区判别值rejudge选择相应的lambda计算公式
		switch(rejudge) {
			case 1:
				lambda = 64/re;
				break;
			case 2:
				lambda = -1; //过渡区无法计算，返回错误值
				break;
			case 3:
				lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));
				break;
			case 4:
				lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));
				break;
			case 5:
				lambda = 1/(4*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7)*Math.log10(5.1286/Math.pow(re,0.89)+n/3.7));
				break;		
		}

		//返回沿程阻力系数lambda	
		return lambda;
	}

/*
	雷诺数re的计算，采用雷诺数通常计算公式
	2300为层流紊流分界，紊流细分待完善
	11.2 层流判别已添加
	11.3 判断步骤改入lambda计算部分
	*/
	public static double calRe(double v, double d, double nu) {	
		
		//计算雷诺数
		double re = v*d/nu;

		//返回雷诺数re
		return re;
	}


/*
	流体的运动粘度nu的计算，采用水的运动粘度经验公式，仅与温度t相关
	*/
	public static double calNu(double t) {
		
		//计算水的运动粘度，采用水的运动粘度经验公式，因此只可针对输水管道使用
		double nu = 0.000001775/(1+0.0337*t+0.000221*t*t);
		
		//返回运动粘度nu
		return nu;
	}

/*
	局部水头损失hw的计算
	*/
	public static double calHj(double v, ArrayList<Double> zetaList, double g)	{
		
		//此处假定管内流速不变，则局部水头损失系数可以简单相加
		double 	zetatotal = 0;
		for (int i = 0; i < zetaList.size(); i++) {
			zetatotal = zetatotal + (double)zetaList.get(i);
		}

		//局部水头损失hj计算
		double hj = zetatotal*v*v/(2*g); 
		
		//返回局部水头损失值hj
		return hj;
	}

/*
	局部水头损失系数zeta的计算,参数未设计
	*/
	public static ArrayList<Double> calZeta() {
		
		//zetaList中包含该段管道中所有的局部水头损失系数
		ArrayList<Double> zetaList = new ArrayList<Double>();

		//仅测试用，未进行匹配	
		zetaList.add(0.015);
		zetaList.add(0.025);
		zetaList.add(0.005);
		zetaList.add(0.030);

		//返回局部水头损失列表
		return zetaList;
	}
}