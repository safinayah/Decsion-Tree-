/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import java.util.Arrays;
import one.project.deseciontree.model.FrequencyTable;

/**
 *
 * @author ayah
 */
public class EntropyCalcuations {

    double yesTemp = 0;
    double noTemp = 0;
    double totalTemp = 0;
    double p = 0.0;
    double aEntropy;
    double yesVal = 0.0;
    double noVal = 0.0;
    double fEntropy = 0;

    double calculateEntropy(FrequencyTable fTable, int total) {

        int[][] freqTable = fTable.getfTable();

//        System.out.println( "             " + Arrays.deepToString(fTable.getfTable()));
        for (int i = 0; i < fTable.getfTable().length; i++) {

            yesTemp = freqTable[i][0];
//            System.out.println("1 :       "+yesTemp);
            noTemp = freqTable[i][1];
//            System.out.println("2 :       "+noTemp);

            totalTemp = freqTable[i][2];
//            System.out.println("3 :       "+totalTemp+"\n\n\n\n");
            if (yesTemp == 0 || noTemp == 0 || totalTemp == 0) {
                fEntropy = 0;
            } else {
                p = calculateP(totalTemp, total);
//                System.out.println("totalTemp : " + totalTemp + "  total :  " + total);
                yesVal = yesTemp / totalTemp;
                noVal = noTemp / totalTemp;

                aEntropy = -((yesVal * Math.log(yesVal)) / Math.log(2)) - ((noVal * Math.log(noVal)) / Math.log(2));
//                System.out.println("\naEnt :  " + aEntropy);

                fEntropy = p * aEntropy;
                fEntropy = fEntropy + fEntropy;

//                System.out.println("\nfEnt :  " + fEntropy);
                return fEntropy;
            }
        }

        return fEntropy;

    }

    private double calculateP(double featureTotal, int total) {

        return featureTotal / total;
    }

}
