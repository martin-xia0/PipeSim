package com.component;

public class Component {
    public int id;
    public String name;
    public int generalType;
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setGeneralType(int type) {
        this.generalType = type;
    }

    public int getGeneralType() {
        return generalType;
    }
}
