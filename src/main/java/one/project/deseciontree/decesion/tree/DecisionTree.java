/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import java.io.IOException;
import one.project.deseciontree.dao.DataDAO;
import one.project.deseciontree.model.DataSet;
import one.project.deseciontree.model.FrequencyTable;
import weka.core.Instances;

/**
 *
 * @author ayah
 */
public class DecisionTree {
    
    FrequencyTable fTable; 
   public void trace() throws IOException{
          DataSet dataSet = DataDAO.readFile("/home/ayah/test.arff");
        Instances allData=  DataDAO.read("/home/ayah/test.arff");
//         for (int i = 0; i < allData.numAttributes(); i++) {
//             for(int j=0; j< allData.){}
//         }




    
   }
    
    
}
