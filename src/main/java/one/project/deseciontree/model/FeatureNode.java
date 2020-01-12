/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayah
 */
public class FeatureNode {
    private String name; 
    private List <Double> attributes = new ArrayList<>();

    public FeatureNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List <Double> getAttributes() {
        return attributes;
    }

    public void setAttributes(List <Double> attributes) {
        this.attributes = attributes;
    }
    
    
    
    
    
}
