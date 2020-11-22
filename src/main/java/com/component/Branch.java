package com.component;
import java.util.*;

//pipelinelist pipenodelist
public class Branch extends Component{
    public boolean mainBranch;
    List<Component> branch = new ArrayList<Component>();

    public Branch(){
        mainBranch = false;
        branch = null;
    }
    public Branch(boolean mainBranch, Component[] pipelist){
        this.mainBranch = mainBranch;
        for(int i = 0; i < pipelist.length; i++){
            this.branch.add(pipelist[i]);
        }
    }
}
