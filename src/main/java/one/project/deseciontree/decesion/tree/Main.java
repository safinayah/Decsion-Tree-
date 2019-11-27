/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import java.io.IOException;
import one.project.deseciontree.dao.DataDAO;
import one.project.deseciontree.model.ClassifiedFeature;
import one.project.deseciontree.model.DataSet;
import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class Main {
    
    public static void main(String[] args) throws IOException{
        
        DataSet dataSet = DataDAO.readFile("./mushroom.arff");
        for(ClassifiedFeature cf : dataSet.getData()){
            for(String value : cf.getFeatureVector()){
                System.out.print(value+";");
            }
            System.out.println("class="+cf.getClassifedClass());
        }
        
            FrequencyTable ft = dataSet.calculateFrequencyTable();
            for(int i = 0 ; i< dataSet.getData().get(0).getFeatureVector().size();i++){
                System.out.println(i +":"+ ft.getTotalCount(String.valueOf(i)));
            }
    }
}
