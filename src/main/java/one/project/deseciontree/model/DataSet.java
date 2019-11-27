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
    
    public FrequencyTable calculateFrequencyTable(){
       FrequencyTable ft = new FrequencyTable();
       for(ClassifiedFeature cf : data){
           for(int i=0; i<cf.getFeatureVector().size();i++){
               ft.addToCount(String.valueOf(i), cf.getFeatureVector().get(i));
           }
       }
       return ft;
    }
    
}
