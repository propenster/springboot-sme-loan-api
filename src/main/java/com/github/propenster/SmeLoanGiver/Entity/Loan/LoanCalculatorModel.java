package com.github.propenster.SmeLoanGiver.Entity.Loan;

import sun.text.resources.cldr.hi.FormatData_hi;

public class LoanCalculatorModel {

    private Double loanAmount;
    private int repaymentPeriod;
    private double interestRate;
    //private double loanMonthlyPayment; //will have only a getter no setter readonly...

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

//    public double getLoanMonthlyPayment() {
//        double r = (getInterestRate()/100) / 12;
//        double n = 12 * getRepaymentPeriod();
//        return (Math.pow((1 + r), n)-1) / (r * Math.pow((1 + r), n));
//    }



    @Override
    public String toString() {
        return "LoanCalculatorModel{" +
                "loanAmount=" + loanAmount +
                ", repaymentPeriod=" + repaymentPeriod +
                ", interestRate=" + interestRate +
                '}';
    }
    // n = 12 * repaymentPeriod
    // double r = (interestRate / 100) / 12 monthlyPaymentsPerYear

    // loanMonthlyPayment = ((1 + r)^n)-1) / (r * (1 + r)^n)

}
