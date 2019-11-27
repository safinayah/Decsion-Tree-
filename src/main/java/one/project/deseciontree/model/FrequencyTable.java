/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ayah
 */
public class FrequencyTable {
    
    
//map contains the frequency table Integer is the code of the attribute 
    //set number of occurancies in the target class 
    Map<String, Map<String,Integer>> frequencyTable = new HashMap<>();

    /**
     *
     * @param featureToSet index of the feature 
     * @param featureValue value of the feature 
     */
    public void addToCount(String featureToSet, String featureValue) {
         if(frequencyTable.get(featureToSet)==null){
            frequencyTable.put(featureToSet,new HashMap<>());
        }
        Integer i = frequencyTable.get(featureToSet).get(featureValue);
        if(i ==null){
            i=0;
        }
        i = i +1;
        frequencyTable.get(featureToSet).put(featureValue, i);
    }

    /**
     *
     * @param featureToGet
     * @return
     */
    public int getTotalCount(String featureToGet) {
        int i=0;
        for(Integer value : frequencyTable.get(featureToGet).values()){
            i = i  + value;
        }
        return i;
    }
    
    /**
     * 
     * @param featureToGet
     * @param featureValue
     * @return 
     */
    
    public int getCountOfValue(String featureToGet, String featureValue){
        return frequencyTable.get(featureToGet).get(featureValue);
    }

}
