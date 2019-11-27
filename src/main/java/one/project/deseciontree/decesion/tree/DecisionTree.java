/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.project.deseciontree.decesion.tree;

import java.io.IOException;
import one.project.deseciontree.dao.DataDAO;
import one.project.deseciontree.model.DataSet;

/**
 *
 * @author ayah
 */
public class DecisionTree {

    public void findOccurances() throws IOException {
        DataSet dataSet = DataDAO.readFile("./mushroom.arff");
        
        

    }

}
