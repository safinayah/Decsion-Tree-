/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ayah
 */
public class ClassifiedFeature {

    private List<String> featureVector = new ArrayList<>();
    private String classifedClass;
    private String name;
    private double[] featureAttribute;
    private boolean taken;
    private double informationGain;
    
 
    void inti(){
        taken= false;
    
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     *
     * @return
     */
    public List<String> getFeatureVector() {
        return featureVector;
    }

    /**
     *
     * @param featureVector
     */
    public void setFeatureVector(List<String> featureVector) {
        this.featureVector = featureVector;
    }

    /**
     *
     * @return
     */
    public String getClassifedClass() {
        return classifedClass;
    }

    /**
     *
     * @param classifedClass
     */
    public void setClassifedClass(String classifedClass) {
        this.classifedClass = classifedClass;
    }

    public double[] getFeatureAttribute() {

        return featureAttribute;
    }

    public void setFeatureAttribute(double[] featureAttribute) {
        this.featureAttribute = featureAttribute;
    }
    

    public boolean isTaken() {
        return taken;
    }

    
    
    
    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public double getInformationGain() {
        return informationGain;
    }

    public void setInformationGain(double informationGain) {
        this.informationGain = informationGain;
    }
    
    

}
