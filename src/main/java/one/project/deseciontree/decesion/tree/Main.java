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

  public static void main(String[] args) throws IOException {

    /**
     * Reads the dataset and prints out all feature vectors
     */
    DataSet dataSet = DataDAO.readFile("./mushroom.arff");
    for (ClassifiedFeature cf : dataSet.getData()) {
      for (String value : cf.getFeatureVector()) {
        System.out.print(value + ";");
      }
      System.out.println("class=" + cf.getClassifedClass());
    }

    /*
     * Calculates the frequency table, and gets the total count of all values for all attributes in
     * a feature vector. For example,
     */
    // Feature|Val1|val2|val3| Total
    // 1      | 5  | 1  | 2  | 8
    // 2      | 3  | 2  | 3  | 8
    // 3      | 4  |NULL| 4  | 8
    //
    // Will print
    // 1 : 8
    // 2 : 8
    // 3 : 8
    FrequencyTable ft = dataSet.calculateFrequencyTable();
    for (int i = 0; i < dataSet.getData().get(0).getFeatureVector().size(); i++) {
      System.out.println(i + ":" + ft.getTotalCount(String.valueOf(i)));
    }
    System.out.println("______________________________");
    //get the count of how many times feature 0 had a value of 0.0
    System.out.println("0 : " + ft.getCountOfValue(String.valueOf(0), String.valueOf(0.0D)));
  }
}
