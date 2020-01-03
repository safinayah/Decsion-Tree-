/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class EntropyCalcuations {

    /**
     *
     *
     * @param fTable
     * @param totalData
     * @return
     */
    public double calculateAttributeEntopy(FrequencyTable fTable, int totalData) {

        double entropy = 0.0;
        int featureAtrributeOne = 0;
        int fratureAttributeTwo = 0;

        int[][] freqTable = fTable.getfTable();
        for (int i = 0; i < freqTable.length; i++) {
//          
            if (freqTable[i][0] == 0 || freqTable[i][1] == 0) {

                entropy = 0;

            } else if (freqTable[i][0] == freqTable[i][1]) {

                entropy = 1;

            } else {

                int poisonTotal = 0;
                int edable = 0;

                poisonTotal += freqTable[i][1];
                edable += freqTable[i][0];

                featureAtrributeOne = freqTable[i][0];
                fratureAttributeTwo = freqTable[i][1];

                entropy = calculateP(freqTable[i][2], totalData) * (calculateFeatureEntropy(featureAtrributeOne, freqTable[i][2]) + calculateFeatureEntropy(fratureAttributeTwo, freqTable[i][2]));
                
            }

            entropy += entropy;
        }

        return entropy;
    }

    /**
     *
     * @param featureTotal
     * @param total
     * @return
     */
    private double calculateP(int featureTotal, int total) {//checked   
        double p = (double) featureTotal / (double) total;
        return (double) featureTotal / (double) total;

    }

    /**
     *
     *
     * @param attributeTotal
     * @param total
     * @return current entropy divided by two
     */
    private double calculateFeatureEntropy(int attributeTotal, int total) {
        double mul = ((double) attributeTotal / total);

        double currentEntropy = Math.log(attributeTotal / (double) total) / Math.log(2);

        return currentEntropy * mul * -1;
    }

}
