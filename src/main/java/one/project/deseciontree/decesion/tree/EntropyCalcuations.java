/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class EntropyCalcuations {

    public double calculateAttributeEntopy(FrequencyTable fTable) {
      int [][]  freqTable = fTable.getfTable(); 
        for(int i=0 ; i<freqTable.length;i++){
            if (freqTable[0][i]==0 || freqTable[1][i]==0){
                return 0 ; 
                
            }else if(freqTable[0][i]==freqTable[1][i]){
                return 1; 
                            
            }else{
                int poisonTotal = freqTable[i][1]++; 
                int ediable = freqTable[i][0]++; 
                int total = freqTable[i][2]++; 
                
//                return (calculateFeatureEntropy(freqTable[i][2], i))
            
            
            }
        
        
        }
        
        return 0;
    }
    
/**
 * 
 * 
 * @param attributeTotal
 * @param total
 * @return current entropy divided by two 
 */
    public double calculateFeatureEntropy(int attributeTotal, int total){
        double currentEntropy = Math.log(attributeTotal/(double)total)/Math.log(2);
    
        
        return currentEntropy; 
    }
    
 
    
    

}
