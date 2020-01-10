/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree.calculations;

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

    public double calculateEntropy(FrequencyTable fTable, int total) {

        int[][] freqTable = fTable.getfTable();

        for (int i = 0; i < fTable.getfTable().length; i++) {

            yesTemp = freqTable[i][0];
            noTemp = freqTable[i][1];

            totalTemp = freqTable[i][2];

            if (yesTemp == noTemp) {
                p = calculateP(totalTemp, total);
                fEntropy = p;
            } else if (noTemp == 0 || yesTemp == 0) {
                fEntropy = 0;
            } else {
                p = calculateP(totalTemp, total);

                yesVal = yesTemp / totalTemp;
                noVal = noTemp / totalTemp;

                aEntropy = featureEntropy(yesVal, noVal);
//                System.out.println(i+"  Entroooopyyyy   : :   "+aEntropy);
                fEntropy = p * aEntropy;
            }

            totalEntropy = totalEntropy + fEntropy;

        }

        return totalEntropy;

    }

    public double featureEntropy(double yesVal, double noVal) {

        return -((yesVal * Math.log(yesVal)) / Math.log(2)) - ((noVal * Math.log(noVal)) / Math.log(2));
    }

    private double calculateP(double featureTotal, int total) {

        return featureTotal / total;
    }

}
