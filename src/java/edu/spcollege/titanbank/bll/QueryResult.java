/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author rmeijer
 */
public class QueryResult {
    private Vector<String> columnNames = new Vector<String>();
    private Vector<String> fieldValues = new Vector<String>();
    
    public void addColumnName(String name) {
        columnNames.add(name);
    }
    public void addFieldValue(String value) {
        fieldValues.add(value);
    }
    public Iterator<String> columnNamesIterator() {
        return columnNames.iterator();
    }
    public Iterator<String> fieldValuesIterator() {
        return fieldValues.iterator();
    }

}
