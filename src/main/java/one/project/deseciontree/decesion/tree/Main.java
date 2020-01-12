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
import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class Main {

    public static void main(String[] args) throws IOException {

   
        String fileName = FrequencyTableConstants.FILE_NAME;
        DataSet dataSet = DataDAO.readFile(fileName);

        int size = dataSet.getData().size();
        int numOfAttributes = DataDAO.read(fileName).numAttributes();
        double[] featureAttributes;
        FrequencyTable ftable;
        ClassifiedFeature cf;
        EntropyCalcuations eCal;

        List<Double> featueGainList = new ArrayList<>();

        for (int i = 0; i < size; i++) {//change size to numOfAttributes when use the original data

            int featureAttributeSize = DataDAO.read(fileName).attribute(i).numValues();
            featureAttributes = new double[featureAttributeSize];
            cf = new ClassifiedFeature();
            cf.setClassifedClass(dataSet.getData().get(i).getClassifedClass());
            cf.setFeatureVector(dataSet.getData().get(i).getFeatureVector());

            for (int j = 0; j < featureAttributeSize; j++) {
                featureAttributes[j] = j;
            }
            cf.setFeatureAttribute(featureAttributes);

            if (cf.isTaken() == false) {

                ftable = new FrequencyTable(dataSet, cf.getFeatureAttribute(), i);

                eCal = new EntropyCalcuations();

                double ans = eCal.calculateEntropy(ftable, size);
                InformationGainCalculations IG = new InformationGainCalculations();
                double featureGain = IG.caluclateFeatureGain(ans);
                featueGainList.add(featureGain);
                cf.setInformationGain(featureGain);

            }

        }
        Collections.reverse(featueGainList);
   

    }
}
