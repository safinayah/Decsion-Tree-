/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import one.project.deseciontree.constants.FrequencyTableConstants;
import one.project.deseciontree.dao.DataDAO;
import one.project.deseciontree.decesion.tree.calculations.EntropyCalcuations;
import one.project.deseciontree.decesion.tree.calculations.InformationGainCalculations;
import one.project.deseciontree.model.ClassifiedFeature;
import one.project.deseciontree.model.DataSet;
import one.project.deseciontree.model.FeatureNode;
import one.project.deseciontree.model.FrequencyTable;
import one.project.deseciontree.model.Node;

/**
 *
 * @author ayah
 */
public class Main {

    public static void main(String[] args) throws IOException {
        buildTree();
   

    }

    static DataSet fillData() throws IOException {

        String fileName = FrequencyTableConstants.FILE_NAME;
        DataSet dataSet = DataDAO.readFile(fileName);

        int size = dataSet.getData().size();
        int numOfAttributes = DataDAO.read(fileName).numAttributes();
        double[] featureAttributes;
        FrequencyTable ftable;
        ClassifiedFeature cf;
        EntropyCalcuations eCal;

        for (int i = 0; i < numOfAttributes - 1; i++) {//change size to numOfAttributes when use the original data

            int featureAttributeSize = DataDAO.read(fileName).attribute(i).numValues();
            featureAttributes = new double[featureAttributeSize];
            cf = new ClassifiedFeature();
            cf.setClassifedClass(dataSet.getData().get(i).getClassifedClass());
            cf.setFeatureVector(dataSet.getData().get(i).getFeatureVector());

            for (int j = 0; j < featureAttributeSize; j++) {
                featureAttributes[j] = j;

            }
//            cf.setFeatureAttribute(featureAttributes);
            dataSet.getData().get(i).setFeatureAttribute(featureAttributes);
//            System.out.println(dataSet.getData().get(i).getFeatureAttribute());

            dataSet.getData().get(i).setName(DataDAO.read(fileName).attribute(i).name());

            ftable = new FrequencyTable(dataSet, featureAttributes, i);

            eCal = new EntropyCalcuations();

            double ans = eCal.calculateEntropy(ftable, size);
            InformationGainCalculations IG = new InformationGainCalculations();
            double featureGain = IG.caluclateFeatureGain(ans);

            dataSet.getData().get(i).setInformationGain(featureGain);

        }

        return dataSet;
    }

    static FeatureNode highestGain() throws IOException {

        FeatureNode fn = new FeatureNode();

        String fileName = FrequencyTableConstants.FILE_NAME;
        int numOfAttributes = DataDAO.read(fileName).numAttributes();

        String featureName = null;
        List<Double> attributes = new ArrayList<>();

        DataSet dataSet = fillData();

        int size = dataSet.getData().size();

        List<Double> featuerGainList = new ArrayList<>();

        for (int i = 0; i < dataSet.getData().size(); i++) {
            featuerGainList.add(dataSet.getData().get(i).getInformationGain());
        }

        Collections.reverse(featuerGainList);
        double highestGain = featuerGainList.get(0);

        for (int i = 0; i <numOfAttributes-1; i++) {
            if (dataSet.getData().get(i).getInformationGain() == highestGain) {
                dataSet.getData().get(i).getFeatureAttribute();
                int featureAttributeSize = DataDAO.read(fileName).attribute(i).numValues();

                for (int j = 0; j < featureAttributeSize; j++) {
                    attributes.add(dataSet.getData().get(i).getFeatureAttribute()[j]);
                    System.out.println(dataSet.getData().get(i).getFeatureAttribute()[j]);

                }
                featureName = dataSet.getData().get(i).getName();
                dataSet.getData().get(i).setTaken(true);

            }

        }
        fn.setAttributes(attributes);
        fn.setName(featureName);
//        System.out.println(featureName);

        return fn;

    }

    static void buildTree() throws IOException {

        highestGain();

        Node node = new Node(null);
        String temp = null;
        Node parentNode = new Node(null);
        parentNode.setId(highestGain().getName());
        for (int i = 0; i < highestGain().getAttributes().size(); i++) {
            temp = "" + highestGain().getAttributes().get(i);

            node = Node.addChild(parentNode, temp);

        }

        node.printTree(parentNode, " ");
    }

}
