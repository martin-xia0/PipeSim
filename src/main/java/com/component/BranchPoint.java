package com.component;
import java.util.*;
//树结构
public class BranchPoint extends Branch{ 
    
    public List<Branch> branchPointList = new ArrayList<Branch>();
    public Map<String, Branch> branchPointMap = new HashMap<String, Branch>(); 
    
    public void setBranchPointList(Branch[] branch) {
        for(int i = 0; i < branch.length; i++){
            this.branchPointList.add(branch[i]);
        }
    }
    public List<Branch> getBranchPointList() {
        return branchPointList;
    }
    public void setBranchPointMap() {
        for(int i = 0; i < this.branchPointList.size(); i++){
            branchPointMap.put(this.branchPointList.get(i).getName(), this.branchPointList.get(i));
        }
    }
    public Map<String, Branch> getBranchPointMap() {
        return branchPointMap;
    }
    public double getQuantity() {
        // get total quantity 
        double quantity = 0;
        return quantity;
    }
}
    
