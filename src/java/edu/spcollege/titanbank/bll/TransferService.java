package edu.spcollege.titanbank.bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferService implements Serializable {
    
    ArrayList<Transfer> transactions;
    String transferStatus;
    
    public TransferService(){
        transactions = new ArrayList<>();
        transferStatus = "";
    }
    
    public void transfer(Transfer request) {
        if(request.getWhenTo() == Transfer.ScheduleType.FUTURE)
            transactions.add(request);
        else{
            try {
                request.getSource().withdraw(request.getAmount());
                request.getDestination().deposit(request.getAmount());
                request.completeTransaction();
                transactions.add(request);
            } catch (InsufficientFundsException ex) {
                Logger.getLogger(TransferService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List getTransactions(Transfer.TransferStatus status){
        ArrayList<Transfer> results = new ArrayList<>();
        for(Transfer request: transactions){
            if(request.getStatus() == status)
                results.add(request);
        }
        return Collections.unmodifiableList(results);
    }
    
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
    
        
    public List getTransactions(String transferStatus){
        ArrayList<Transfer> results = new ArrayList<>();
        for(Transfer request: transactions){
            if(request.getTransferStatus() == transferStatus)
                results.add(request);
        }
        return results;
        //return Collections.unmodifiableList(results);
    }
}
