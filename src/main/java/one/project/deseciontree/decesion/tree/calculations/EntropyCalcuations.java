/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree.calculations;

import one.project.deseciontree.constants.FrequencyTableConstants;
import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class EntropyCalcuations {

    private double yesTemp = 0;
    private double noTemp = 0;
    private double totalTemp = 0;
    private double p = 0.0;
    private double aEntropy;
    private double yesVal = 0.0;
    private double noVal = 0.0;
    private double fEntropy = 0;
    private double totalEntropy = 0;
/**
 * calculates the entropy(targetClass,Feature) 
 * 
 * @param fTable
 * @param total
 * @return features entropy
 */
    public double calculateEntropy(FrequencyTable fTable, int total) {

        int[][] freqTable = fTable.getfTable();

        for (int i = 0; i < fTable.getfTable().length; i++) {

            yesTemp = freqTable[i][FrequencyTableConstants.EDABLE_iNDEX];
            noTemp = freqTable[i][FrequencyTableConstants.POISINAS_iNDEX];

            totalTemp = freqTable[i][FrequencyTableConstants.TOTAL_INDEX];

            if (yesTemp == noTemp) {
                p = calculateP(totalTemp, total);
                fEntropy = p;
            } else if (noTemp == 0 || yesTemp == 0) {
                fEntropy = 0;
            } else {
                p = calculateP(totalTemp, total);

                yesVal = yesTemp / totalTemp;
                noVal = noTemp / totalTemp;

                aEntropy = entropyEquation(yesVal, noVal);
                fEntropy = p * aEntropy;
            }

            totalEntropy = totalEntropy + fEntropy;

        }

        return totalEntropy;

    }
    /**
     * decision tree entropy formula
     * @param yesVal all values are classified as ediable  
     * @param noVal  all values are classified as poisinas 
     * @return 
     */
    public double entropyEquation(double yesVal, double noVal) {

        return -((yesVal * Math.log(yesVal)) / Math.log(2)) - ((noVal * Math.log(noVal)) / Math.log(2));
    }
/**
 * calculates the p value that is the division answer form all occurances of the given feature by the total 
 * @param featureTotal
 * @param total
 * @return p 
 */
    private double calculateP(double featureTotal, int total) {

        return featureTotal / total;
    }

}
