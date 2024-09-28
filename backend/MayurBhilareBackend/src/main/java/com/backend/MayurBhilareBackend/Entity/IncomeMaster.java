package com.backend.MayurBhilareBackend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class IncomeMaster {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long  incomeId;
   private  String causeOfPayment;
   private LocalDate paymentDate;
   private  String fullName;
   private String email;
   private  String locality;
   private String paymentMode;
   private  double totalAmount;
   private  double receivedAmount;
   private  String ExpenseType;
   private double expenseAmount;
   private  String paymentNote;
   private  double pendingAmount;
   private double netProfit;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "split_expense_id", referencedColumnName = "splitExpenseId") // Defines the foreign key in IncomeMaster
    private SplitExpenseMaster splitExpense;

    public IncomeMaster(){
        super();
    }
    public IncomeMaster(Long incomeId, String causeOfPayment, LocalDate paymentDate,
                        String fullName, String email, String locality, String paymentMode,
                        double totalAmount, double receivedAmount, String expenseType,
                        double expenseAmount, String paymentNote, double pendingAmount,
                        double netProfit, SplitExpenseMaster splitExpense) {
        this.incomeId = incomeId;
        this.causeOfPayment = causeOfPayment;
        this.paymentDate = paymentDate;
        this.fullName = fullName;
        this.email = email;
        this.locality = locality;
        this.paymentMode = paymentMode;
        this.totalAmount = totalAmount;
        this.receivedAmount = receivedAmount;
        ExpenseType = expenseType;
        this.expenseAmount = expenseAmount;
        this.paymentNote = paymentNote;
        this.pendingAmount = pendingAmount;
        this.netProfit = netProfit;
        this.splitExpense = splitExpense;
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getCauseOfPayment() {
        return causeOfPayment;
    }

    public void setCauseOfPayment(String causeOfPayment) {
        this.causeOfPayment = causeOfPayment;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public String getExpenseType() {
        return ExpenseType;
    }

    public void setExpenseType(String expenseType) {
        ExpenseType = expenseType;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }

    public double getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(double pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public SplitExpenseMaster getSplitExpense() {
        return splitExpense;
    }

    public void setSplitExpense(SplitExpenseMaster splitExpense) {
        this.splitExpense = splitExpense;
    }

    @Override
    public String toString() {
        return "IncomeMaster{" +
                "incomeId=" + incomeId +
                ", causeOfPayment='" + causeOfPayment + '\'' +
                ", paymentDate=" + paymentDate +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", locality='" + locality + '\'' +
                ", paymentMode='" + paymentMode + '\'' +
                ", totalAmount=" + totalAmount +
                ", receivedAmount=" + receivedAmount +
                ", ExpenseType='" + ExpenseType + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", paymentNote='" + paymentNote + '\'' +
                ", pendingAmount=" + pendingAmount +
                ", netProfit=" + netProfit +
                ", splitExpense=" + splitExpense +
                '}';
    }
}
