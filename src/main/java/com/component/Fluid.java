package com.component;

class Fluid {
    
    private double quantity;
    private double velocity;
    public double nu;

    public Fluid(){
        this.quantity = -1;
        this.velocity = -1;
    }    
    public Fluid(double quantity){
        this.quantity = quantity;
        this.velocity = 0;     
    }
    
    
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getQuantity() {
        return quantity;
    }
    
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
    public double getVelocity() {
        return velocity;
    }
}