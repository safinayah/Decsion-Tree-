/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import one.project.deseciontree.dao.DataDAO;

/**
 *
 * @author ayah
 */
public class FrequencyTable {

//1 = p 
    public FrequencyTable(DataSet dataset, double[] featureAttributes, int index) throws IOException {
        List<Double> feature = new ArrayList<>();
        int[][] fTable = new int[featureAttributes.length][3];
        for (int i = 0; i < dataset.getData().size(); i++) {
//            System.out.println("size : " + dataset.getData().size());
            for (int j = 0; j < featureAttributes.length; j++) {
//                System.out.println("length : " + featureAttributes.length);
                System.out.println("ffff " + dataset.getData().get(i).getFeatureVector().get(index));
        

                if ((dataset.getData().get(i).getFeatureVector().get(index)).equals("" + featureAttributes[j])) {//2 equals to total 
                    fTable[j][2]++;//inc total in ftable 

                    if (dataset.getData().get(i).getClassifedClass().equals("" + 1.0)) {//1 equlas to p 

                        fTable[j][1]++; // inc p's total 

                    } else {// 0 equals to e
                        fTable[j][0]++; // inc e's total   System.out.println("length : " + featureAttributes.length)
                        System.out.println("3_________________________");

                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(fTable));
    }
}
