package com.component;

//管道节点，包含管道节点的基本参数（材料，直径，局部水头损失系数）
//应当添加下选类型，以及坐标点
public class PipeNode extends Component {    
  
  public int material;
  public double diameter;
  public double zeta;
  public int pipeNodeType;
  
  public PipeNode(){
    material = -1;
    diameter = -1;
    zeta = -1;
    setGeneralType(2);
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
  public void setPipeNodeType(int pipeNodeType) {
    this.pipeNodeType = pipeNodeType;
  }
  public int getPipeNodeType() {
    return pipeNodeType;
  }
}
