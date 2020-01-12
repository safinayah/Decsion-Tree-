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
public class DataSet {
    
    
    
  
    private List<ClassifiedFeature> data = new ArrayList<>();

    public List<ClassifiedFeature> getData() {
        return data;
    }
 

    public void setData(List<ClassifiedFeature> data) {
        this.data = data;
    }
    
    

    @Override
    public String toString() {
        return "DataSet{" + "data=" + data + '}';
    }
    
    

}
