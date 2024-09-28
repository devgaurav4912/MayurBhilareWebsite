package com.backend.MayurBhilareBackend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.core.SpringVersion;

@Entity
public class SplitExpenseMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long splitExpenseId;
    private  double splitAmount;
    private  String expenseType;

    public  SplitExpenseMaster (){
        super();
    }

    public SplitExpenseMaster(Long splitExpenseId, double splitAmount, String expenseType) {
        this.splitExpenseId = splitExpenseId;
        this.splitAmount = splitAmount;
        this.expenseType = expenseType;
    }

    public Long getSplitExpenseId() {
        return splitExpenseId;
    }

    public void setSplitExpenseId(Long splitExpenseId) {
        this.splitExpenseId = splitExpenseId;
    }

    public double getSplitAmount() {
        return splitAmount;
    }

    public void setSplitAmount(double splitAmount) {
        this.splitAmount = splitAmount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    @Override
    public String toString() {
        return "SplitExpenseMaster{" +
                "splitExpenseId=" + splitExpenseId +
                ", splitAmount=" + splitAmount +
                ", expenseType='" + expenseType + '\'' +
                '}';
    }
}
