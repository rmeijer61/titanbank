package edu.spcollege.titanbank.bll;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class Transfer implements Serializable {
    private int transferId = 0;
    private int customerId = 0;
    private String transferStatus;
    private int fromAccountNum = 0;
    private int toAccountNum = 0;
    private double amount;
    private String amountString;
    private boolean transferImmediately = false;
    private java.util.Date scheduleDate;
    private String transferEnterDateString;
    private boolean isFound = false;
    private List<Transfer> transferList;
    //
    private String scheduleDateFormatted = "";
    private String amountFormatted = "";
    private Currency currency;
    //
    private String jspPattern = "MM/dd/yyyy";
    private SimpleDateFormat jspDateFormat = new SimpleDateFormat(jspPattern);
    private String mysqlPattern = "yyyy-MM-dd";
    private SimpleDateFormat mysqlDateFormat = new SimpleDateFormat(mysqlPattern);
    //
    private Account source;
    private Account destination;
    private String sourceType;
    private String destinationType;
    private ScheduleType whenTo;
    private TransferStatus status;
    
    public enum ScheduleType{
        IMMEDIATELY,
        FUTURE
    }
    
    public enum TransferStatus{
        PENDING,
        COMPLETED,
        ALL
    }
    
    public Transfer() throws SQLException, ClassNotFoundException {
        this.transferId = 0;
        this.customerId = 0;
        this.transferStatus = "";
        this.fromAccountNum = 0;
        this.toAccountNum = 0;
        this.amount = 0.0;
        this.scheduleDate = null;
        this.isFound = false;
    }
    
    public Transfer(int customerId, String transferStatus, int fromAccountNum, int toAccountNum, double amount, 
                    boolean transferImmediately, java.util.Date scheduleDate, java.util.Date transferDate){
        this.customerId = customerId;
        this.transferStatus = transferStatus;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
        this.transferImmediately = transferImmediately;
        this.scheduleDate = scheduleDate;
    }
    
    public Transfer(int customerId, String transferStatus) throws SQLException, ClassNotFoundException{
        this.customerId = customerId;
        this.transferStatus = transferStatus;
        this.isFound = queryTransfer(customerId, transferStatus);
    }
    
    // Data Access
    public int insertTransfer(int customerId, String transferStatus, int fromAccountNum, int toAccountNum, double amount, 
                              boolean transferImmediately, java.util.Date scheduleDate) throws SQLException {
        this.customerId = customerId;
        this.transferStatus = transferStatus;
        this.fromAccountNum = fromAccountNum;
        this.toAccountNum = toAccountNum;
        this.amount = amount;
        this.transferImmediately = transferImmediately;
        
        if (transferImmediately) {
            this.scheduleDate = new java.util.Date();
            System.out.println("Transfer immediately on: " + jspDateFormat.format(scheduleDate));
        }
        if (this.scheduleDate == null) {
            //TODO determine a proper default
            this.scheduleDate = new java.util.Date();
            System.out.println("Schedule date defaults to :" + jspDateFormat.format(scheduleDate));
        }
        
        System.out.println("Create DBTransfer");
        DBTransfer dbtransfer = new DBTransfer();
        System.out.println("Call DBtransfer.insertTransfer");
        this.transferId = dbtransfer.insertTransfer(this);
        return this.transferId;
    }
    
    public boolean queryTransfer(int customerId, String transferStatus) throws SQLException, ClassNotFoundException {
        DBTransfer dbtransfer = new DBTransfer();
        dbtransfer.queryTransfer(customerId, transferStatus);
        
        this.customerId = dbtransfer.getCustomerId();
        this.transferStatus = dbtransfer.getTransferStatus(); 
        this.fromAccountNum = dbtransfer.getFromAccountNum();
        this.toAccountNum = dbtransfer.getToAccountNum();
        this.amount = dbtransfer.getAmount();
        this.transferImmediately = dbtransfer.getTransferImmediately();
        this.scheduleDate = dbtransfer.getScheduleDate();
        this.isFound = dbtransfer.getIsFound();
        return this.isFound;
    }
        
    public boolean queryTransferList(int customerId, String transferStatus) throws SQLException, ClassNotFoundException {
        System.out.println("Transfer.queryTransferList()...");
        this.customerId = customerId;
        this.transferStatus = transferStatus;
        DBTransfer dbtransfer = new DBTransfer();
        isFound = dbtransfer.queryTransferList(customerId, transferStatus);
        
        this.transferList = dbtransfer.getTransferList();
        return this.isFound;
    }
    
    //
    
    public Account getSource() {
        return source;
    }
    public void setSource(Account accountType) {
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
    public Account getDestination() {
        return destination;
    }
    public void setDestination(Account accountType) {
        this.destination = accountType;
    }    

    public ScheduleType getWhenTo() {
        return whenTo;
    }
    public void setWhenTo(ScheduleType whenTo) {
        this.whenTo = whenTo;
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
    
    // Getters and Setters
    //
    public int getTransferId() {
        return this.transferId;
    }
    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }
    public int getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getTransferStatus() {
        return transferStatus;
    }
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
    public int getFromAccountNum() {
        return this.fromAccountNum;
    }
    public void setFromAccountNum(int fromAccountNum) {
        this.fromAccountNum = fromAccountNum;
    }
    public int getToAccountNum() {
        return this.toAccountNum;
    }
    public void setToAccountNum(int toAccountNum) {
        this.toAccountNum = toAccountNum;
    }
    public double getAmount() {
        return this.amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public boolean getTransferImmediately(){
        return this.transferImmediately;
    }
    public void setTransferImmediately(boolean transferImmediately) {
        this.transferImmediately = transferImmediately;
    }
    public java.util.Date getScheduleDate() {
        return this.scheduleDate;
    }
    public void setScheduleDate(java.util.Date ScheduleDate) {
        this.scheduleDate = ScheduleDate;
    }
    public List getTransferList() {
        return this.transferList;
    }
    public boolean getIsFound() {
        return this.isFound;
    }
    
    // Transfer list formatted 
    public String getScheduleDateFormatted() {
        scheduleDateFormatted = jspDateFormat.format(scheduleDate);
        return scheduleDateFormatted;
    }
    public String getAmountFormatted() {
        currency = new Currency();
        currency.setLocale(Locale.US);
        currency.setAmount(this.amount);
        amountFormatted = currency.getFormat();
        return this.amountFormatted;
    }
}
