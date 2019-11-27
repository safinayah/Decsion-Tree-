/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;
import one.project.deseciontree.model.ClassifiedFeature;
import one.project.deseciontree.model.DataSet;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader.ArffReader;

/**
 *
 * @author ayah
 */
public class DataDAO {

    public static DataSet readFile(String filePath) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArffReader arff = new ArffReader(reader);
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        DataSet dataSet = new DataSet();
        data.parallelStream().forEach(new InstanceConsumer(dataSet));
        return dataSet;
    }

    private static class InstanceConsumer implements Consumer<Instance> {

        private final DataSet dataSet;

        public InstanceConsumer(DataSet dataSet) {
            this.dataSet = dataSet;
        }

        @Override
        public void accept(Instance arg0) {
            ClassifiedFeature feature = new ClassifiedFeature();
            double[] attributes = arg0.toDoubleArray();
            for (int i = 0; i < attributes.length; i++) {
                if (i != arg0.classIndex()) {
                    feature.getFeatureVector().add(String.valueOf(attributes[i]));
                } else {                   
                    feature.setClassifedClass(String.valueOf(attributes[i]));
                }
            }
            this.dataSet.getData().add(feature);
        }

    }
}
