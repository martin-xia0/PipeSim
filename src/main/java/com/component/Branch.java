package com.component;
import java.util.*;

//pipelinelist pipenodelist
public class Branch extends Component{
    public boolean mainBranch;
    List<Component> branch = new ArrayList<Component>();

    public Branch(){
        mainBranch = false;
        branch = null;
        setGeneralType(4);
    }
    // public Branch(boolean mainBranch, Component[] pipelist){
    //     this.mainBranch = mainBranch;
    //     for(int i = 0; i < pipelist.length; i++){
    //         this.branch.add(pipelist[i]);
    //     }
    // }
    public void setMainBranch(boolean mainBranch) {
        this.mainBranch = mainBranch;
    }
    public void setBranch(Component[] pipelist) {
        for(int i = 0; i < pipelist.length; i++){
            this.branch.add(pipelist[i]);
        }
    }
}
