package com.component;

//管道节点，包含管道节点的基本参数（材料，直径，局部水头损失系数）
//应当添加下选类型，以及坐标点
public class PipeNode extends Component {    
  public int material;
  public double diameter;
  public double zeta;
}
