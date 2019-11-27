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

    /**
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

}
