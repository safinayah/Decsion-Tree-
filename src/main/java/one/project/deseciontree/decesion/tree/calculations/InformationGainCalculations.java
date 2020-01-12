/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree.calculations;

import java.io.IOException;
import one.project.deseciontree.constants.FrequencyTableConstants;
import one.project.deseciontree.dao.DataDAO;

/**
 *
 * @author ayah
 */
public class InformationGainCalculations {

    /**
     * 
     * 
     * 
     * 
     *
     *
     * @param featureEntropy
     * @return the information gain for the features
     * @throws java.io.IOException
     */
    public double caluclateFeatureGain(double featureEntropy) throws IOException {

        double classEntropy = calcualteTargerGain();

//        mainEntropy= entropyCal.featureEntropy();
        return classEntropy - featureEntropy;
    }

    /**
     *
     *
     * @return the Information Gain for the target class
     * @throws IOException
     */
    private double calcualteTargerGain() throws IOException {
        String fileName = FrequencyTableConstants.FILE_NAME;
        var dataSet = DataDAO.readFile(fileName);

        int size = dataSet.getData().size();
        EntropyCalcuations entropyCal = new EntropyCalcuations();

        double pVal = 0;
        double eVal = 0;
        for (int i = 0; i < size; i++) {
            double temp = Double.parseDouble(dataSet.getData().get(i).getClassifedClass());
            if (temp == 1) {
                pVal++;
            } else {
                eVal++;
            }

        }

        EntropyCalcuations et = new EntropyCalcuations();

        pVal = pVal / size;
        eVal = eVal / size;

        return et.entropyEquation(pVal, eVal);

    }

}
