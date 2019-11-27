/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

/**
 *
 * @author ayah
 */
public class Calculations {

    /**
     *
     * @param occurances number of times that this feature found
     * @param total total number of this feature 
     * @return entropy of one feature 
     */
    public double calculateEntropy(int occurances, int total) {
        double p =occurances/total;
        
        
        return -(p*Math.log(p));
    }

    /**
     *
     * @param rootEtropy
     * @param currentEntropy
     * @return information gain of the current feature with it's root 
     */
    public double calculateInformationGain(double rootEtropy, double currentEntropy) {
        return rootEtropy-currentEntropy;
    }

}
