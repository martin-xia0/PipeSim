package com.main;

import java.util.HashMap;
import java.util.Map;

public class test2{        
    
    public static int material;
    public static double diameter;
    public static double zeta;
    public static Map<Integer, Map> keyMaterial = new HashMap<Integer, Map>();
    public static Map<Double, Double> zetaList1 = new HashMap<Double, Double>();
    public static Map<Double, Double> zetaList2 = new HashMap<Double, Double>();
    
    {
        keyMaterial.put(1, zetaList1);
        keyMaterial.put(2, zetaList2);
        zetaList1.put(0.1, 0.001);
        zetaList1.put(0.2, 0.002);
        zetaList2.put(0.1, 0.002);
        zetaList2.put(0.2, 0.004);
        System.out.println("map data build");
        System.out.println(keyMaterial);
        System.out.println(zetaList1);
    }

    public static double getZeta(Map keyMaterial, int material, double diameter) {
        Object zetalist = keyMaterial.get(material);
        return zetalist.get(diameter);
    }

    public static void main(String[] args) {
        material = 1;
        diameter = 0.3;
        zeta = getZeta(keyMaterial, material, diameter); 
    }  
}