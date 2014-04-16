/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.titanbank.bll;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class Currency {
    private Locale locale;
    private double amount;
    
    public Currency() {
        this.locale = new Locale("en_US");
        this.amount = 0.0;
    }
    
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    
    public void setAmount (double amount) {
        this.amount = amount;
    }
    
    public String getFormat() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(amount);
    }
}
