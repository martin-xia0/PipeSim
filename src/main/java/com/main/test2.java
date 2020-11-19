package com.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2{        
    
    public static double material;
    public static double diameter;
    public static double zeta;
    // public static Map<Integer, Map> keyMaterial = new HashMap<Integer, Map>();
    // public static Map<Double, Double> zetaList1 = new HashMap<Double, Double>();
    // public static Map<Double, Double> zetaList2 = new HashMap<Double, Double>();
    public static Map<List<Double>,Double> zetaList3 = new HashMap<>();
    // {
    //     // keyMaterial.put(1, zetaList1);
    //     // keyMaterial.put(2, zetaList2);
    //     // zetaList1.put(0.1, 0.001);
    //     // zetaList1.put(0.2, 0.002);
    //     // zetaList2.put(0.1, 0.002);
    //     // zetaList2.put(0.2, 0.004);
    //     // System.out.println("map data build");
    //     // System.out.println(keyMaterial);
    //     // System.out.println(zetaList1);
    // }

    // public static double getZeta(Map keyMaterial, int material, double diameter) {
    //     Object zetalist = keyMaterial.get(material);
    //     return zetalist.get(diameter);
    // }

    public static void main(String[] args) {
        material = 1.0;
        diameter = 0.3;
        List<Double> pipetype = new ArrayList<Double>();
        Collections.addAll(pipetype, material ,diameter);
        //pipetype.add(diameter);
        zetaList3.put(pipetype,0.02);
        System.out.println(zetaList3.get(pipetype));
        //zeta = getZeta(keyMaterial, material, diameter); 
    } 
}