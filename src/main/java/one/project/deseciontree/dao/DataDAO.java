/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.dao;

import java.io.BufferedReader;
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

    /**
     * Reads a file and converts it into a dataset
     *
     * @param filePath the path of the file to read
     * @return a dataset
     * @throws IOException
     */
    public static DataSet readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArffReader arffFile = new ArffReader(reader);//read the arff file
        Instances data = arffFile.getData();//extract the datset
        data.setClassIndex(data.numAttributes() - 1);//set the class to be the last attribute
        return convert(data);
    }

    public static Instances read(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        ArffReader arffFile = new ArffReader(reader);//read the arff file
        Instances data = arffFile.getData();//extract the datset
        data.setClassIndex(data.numAttributes() - 1);//set the class to be the last attribute
        return data;
    }

    /**
     * A Consumer class that converts feature Instances to a dataset
     */
    private static class InstanceConsumer implements Consumer<Instance> {

        int feature = 0;

        private final DataSet dataSet;

        public InstanceConsumer(DataSet dataSet) {
            this.dataSet = dataSet;
        }

        @Override
        public void accept(Instance featureInstance) {
            ClassifiedFeature classifiedFeature = new ClassifiedFeature();
            double[] featureINstance = featureInstance.toDoubleArray();
            //System.out.println("lengthhh   ::   "+featureInstance.classIndex());
            for (int i = 0; i < featureINstance.length; i++) {
              
                if (i != featureInstance.classIndex()) {
                    classifiedFeature.getFeatureVector().add(String.valueOf(featureINstance[i]));
                } else {
                    classifiedFeature.setClassifedClass(String.valueOf(featureINstance[i]));
//                    System.out.println("claaaaaaaaaaas :    "+classifiedFeature.getClassifedClass());
                }
            }
            for (int i = 0; i < featureInstance.numAttributes(); i++) {
                classifiedFeature.setName(featureInstance.attribute(i).name());

            }
            this.dataSet.getData().add(classifiedFeature);
        }

    }

    /**
     * Converts a Weka dataset into a dataset for our use
     *
     * @param data the data to convert
     * @return a dataset with the converted data
     */
    private static DataSet convert(Instances data) {
        DataSet dataSet = new DataSet();
        data.stream().forEach(new InstanceConsumer(dataSet));//iterate over the data and convert it'
        return dataSet;
    }
}
