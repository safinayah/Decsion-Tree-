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
  Map<String, Map<String, Integer>> frequencyTable = new HashMap<>();

  /**
   * Adds to the count of a feature instance's value in the frequency table
   *
   * @param featureToSet index of the feature
   * @param featureValue value of the feature
   */
  public void addToCount(String featureToSet, String featureValue) {
    if (frequencyTable.get(featureToSet) == null) {
      frequencyTable.put(featureToSet, new HashMap<>());
    }
    Integer i = frequencyTable.get(featureToSet).get(featureValue);
    if (i == null) {
      i = 0;
    }
    i = i + 1;
    frequencyTable.get(featureToSet).put(featureValue, i);
  }

  /**
   * Gets the total counts of all values of a feature
   *
   * @param featureToGet the index/name of the feature to get
   * @return the count of all instances of a feature
   */
  public int getTotalCount(String featureToGet) {
    int i = 0;
    for (Integer value : frequencyTable.get(featureToGet).values()) {
      i = i + value;
    }
    return i;
  }

  /**
   * Gets the count for a specific value for a feature attribute
   *
   * @param featureToGet the index/name of the feature attribute
   * @param featureValue the value to get
   * @return the number of times this value was repeated in the dataset
   */
  public int getCountOfValue(String featureToGet, String featureValue) {
    return frequencyTable.get(featureToGet).get(featureValue);
  }

}
