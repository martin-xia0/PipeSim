package com.component;

class Fluid {
    
    private double quantity;
    private double velocity;
    private double pressure;

    public Fluid(){
        this.quantity = -1;
        this.velocity = -1;
        this.pressure = -1;
    }    
    public Fluid(double quantity){
        this.quantity = quantity;
        this.velocity = 0;
        this.pressure = 0;      
    }
    
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
    public double getPressure() {
        return pressure;
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
