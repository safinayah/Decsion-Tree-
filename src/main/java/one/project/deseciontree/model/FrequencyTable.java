/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.io.IOException;
import one.project.deseciontree.constants.FrequencyTableConstants;
 

/**
 *
 * @author ayah
 */
public class FrequencyTable {

    
    
    
    private int[][] fTable;

    /**
     *
     * @param dataset
     * @param featureAttributes
     * @param index
     * @throws IOException
     */
    public FrequencyTable(DataSet dataset, double[] featureAttributes, int index) throws IOException {
        fTable = new int[featureAttributes.length][FrequencyTableConstants.FREQ_TABLE_LENGTH];

        for (int i = 0; i < dataset.getData().size(); i++) {

            for (int j = 0; j < featureAttributes.length; j++) {

                if ((dataset.getData().get(i).getFeatureVector().get(index)).equals("" + featureAttributes[j])) {
                    fTable[j][FrequencyTableConstants.TOTAL_INDEX]++;

                    if (dataset.getData().get(i).getClassifedClass().equals("" + FrequencyTableConstants.POISINAS_VALUE)) {

                        fTable[j][FrequencyTableConstants.POISINAS_iNDEX]++;

                    } else {
                        fTable[j][FrequencyTableConstants.EDABLE_iNDEX]++;

                    }
                }
            }

        }
    }

    public int[][] getfTable() {
        return fTable;
    }

    public void setfTable(int[][] fTable) {
        this.fTable = fTable;
    }

}
