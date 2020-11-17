package com.component;


public class test {
    public static void main(String[] args) {
        
        System.out.println("--------------------------");
        System.out.println("work begin");
        System.out.println("==========================");
        
        /*
        Pipe(material,diameter,length)
        material(1.塑料 2.新铸铁 3.旧铸铁 4.新钢铁 5.旧钢铁 6.水泥)
        */
        Pipe pipe1 = new Pipe(1,0.3,3000);
        Pipe pipe2 = new Pipe(1,0.3,1500);
        Pipe pipe3 = new Pipe();
        /*
        Node(material,diameter,type)
        material    (1.塑料 2.新铸铁 3.旧铸铁 4.新钢铁 5.旧钢铁 6.水泥)
        type        (1.弯头 2.闸阀)
        */
        Node node1 = new Node(1,0.3,1);
        Node node2 = new Node(2,0.2,1);
        Node node3 = new Node();
        
        //select pipes and nodes and combine them into lists
        Pipe[] pipelist1 = new Pipe[]{pipe1,pipe2,pipe3};
        Pipe[] pipelist2 = new Pipe[]{pipe1,pipe2};
        Node[] nodelist1 = new Node[]{node1};
        Node[] nodelist2 = new Node[]{node2,node3};
        
        //Network(pipelist,nodelist)
        Network net1 = new Network(pipelist1,nodelist2);
        Network net2 = new Network(pipelist2,nodelist1);
        
        //set quantity
        Fluid flu1 = new Fluid(0.2);

        //calculate
        double totalheadloss1 = CalculatorDW.totalHeadloss(net1, flu1);
        double totalheadloss2 = CalculatorDW.totalHeadloss(net2, flu1);
        
        //result
        System.out.printf("net1 hw = %s,\nnet2 hw = %s\n",totalheadloss1,totalheadloss2);
        
        System.out.println("==========================");
        System.out.println("work finished");
        System.out.println("--------------------------");
    }
}
