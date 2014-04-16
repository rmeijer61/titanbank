package edu.spcollege.titanbank.bll;

import java.io.Serializable;

public class TransferRequest implements Serializable {
    
    private BankAccount source;
    private BankAccount destination;
    private String sourceType;
    private String destinationType;
    private ScheduleType whenTo;
    private String transferDateString;
    private double amount;
    private String amountString;
    private TransferStatus status;
    private String transferStatus;
    private boolean transferImmediately = false;
    private String transferEnterDateString;
    
    public enum ScheduleType{
        IMMEDIATELY,
        FUTURE
    }
    
    public enum TransferStatus{
        PENDING,
        COMPLETED,
        ALL
    }
    
    public TransferRequest (){
        this.amount = 0.0;
        this.source = null;
        this.destination = null;
        this.whenTo = ScheduleType.FUTURE;
        this.transferDateString = "";
        this.amountString="";
        this.status = TransferStatus.PENDING;
        
    }
    public TransferRequest(BankAccount from, BankAccount to, ScheduleType when, double amount){
        this.source = from;
        this.destination = to;
        this.whenTo = when;
        this.amount = amount;
        this.status = TransferStatus.PENDING;
    }
    
    public BankAccount getSource() {
        return source;
    }
    public void setSource(BankAccount accountType) {
        this.source = accountType;
    }
    //
    public String getSourceType() {
        return sourceType;
    }
    public void setSourceType(String accountType) {
        this.sourceType = accountType;
    }
    public String getDestinationType() {
        return destinationType;
    }
    public void setDestinationType(String accountType) {
        this.destinationType = accountType;
    }
    //
    public BankAccount getDestination() {
        return destination;
    }
    public void setDestination(BankAccount accountType) {
        this.destination = accountType;
    }    

    public ScheduleType getWhenTo() {
        return whenTo;
    }
    public void setWhenTo(ScheduleType whenTo) {
        this.whenTo = whenTo;
    }
    
    public String getTransferDateString() {
        return transferDateString;
    }
    public void setTransferDateString(String transferDate) {
        this.transferDateString = transferDate;
    }
    public String getTransferEnterDateString() {
        return transferEnterDateString;
    }
    public void setTransferEnterDateString(String transferEnterDate) {
        this.transferEnterDateString = transferEnterDate;
    }
    public double getAmount(){
        return this.amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getAmountString() {
        return this.amountString;
    }
    public void setAmountString(String amount) {
        this.amountString = amount;
    }
    public boolean getTransferImmediately() {
        return this.transferImmediately;
    }
    public void setTransferImmediately(boolean transferImmediately) {
        this.transferImmediately = transferImmediately;
    }
    
    public TransferStatus getStatus(){
        return this.status;
    }
    public void setStatus(TransferStatus status){
        this.status = status;
    }
     
    public void completeTransaction(){
        this.status = TransferStatus.COMPLETED;
    }
    
    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

}
