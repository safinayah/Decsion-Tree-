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

/**
 *
 * @author ayah
 */
public class Main {

    public static void main(String[] args) throws IOException {

        /**
         * Reads the dataset and prints out all feature vectors
         */
        DataSet dataSet = DataDAO.readFile("/home/ayah/test.arff");

        int size = dataSet.getData().size();
        int[] featureAttribute;

        ClassifiedFeature cf;

        for (int i = 0; i < size; i++) {

            int featureAttributeSize = DataDAO.read("/home/ayah/test.arff").attribute(i).numValues();
            featureAttribute = new int[featureAttributeSize];
            cf = new ClassifiedFeature();
            cf.setClassifedClass(dataSet.getData().get(i).getClassifedClass());
            cf.setFeatureVector(dataSet.getData().get(i).getFeatureVector());
            cf.setName(DataDAO.read("/home/ayah/test.arff").attribute(i).name());

            for (int j = 0; j < featureAttributeSize; j++) {
                featureAttribute[j] = j;
            }
            cf.setFeatureAttribute(featureAttribute);

        }

    }

}
