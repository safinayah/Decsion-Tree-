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

  /**
   * Iterates over the dataset and calculates the frequency tabke
   *
   * @return a frequency table
   */
  public FrequencyTable calculateFrequencyTable() {
    FrequencyTable frequenceyTable = new FrequencyTable();
    for (ClassifiedFeature classifiedFeature : data) {
      for (int i = 0; i < classifiedFeature.getFeatureVector().size(); i++) {
        frequenceyTable.addToCount(String.valueOf(i), classifiedFeature.getFeatureVector().get(i));
      }
    }
    return frequenceyTable;
  }

}
