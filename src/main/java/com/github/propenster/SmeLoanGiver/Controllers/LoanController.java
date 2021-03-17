package com.github.propenster.SmeLoanGiver.Controllers;

import com.github.propenster.SmeLoanGiver.Entity.Loan.LoanCalculatorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoanController {


    //This is for passing Years repayment
    @PostMapping("/api/v1/SmeLoanAccount/localCalculator")
    public ResponseEntity<String> calculateLoan(@RequestBody LoanCalculatorModel loanModel){
            double r = (loanModel.getInterestRate()/100) / 12;
            double n = 12 * loanModel.getRepaymentPeriod(); //dividedby12

            return ResponseEntity.status(HttpStatus.OK)
                    .body("With a loan of $"+ loanModel.getLoanAmount() + " at "+loanModel.getInterestRate() + "% payable for "+ loanModel.getRepaymentPeriod() + " years, \nYou will pay $" + loanModel.getLoanAmount() / ((Math.pow((1 + r), n)-1) / (r * Math.pow((1 + r), n))) + " monthly for the tenure specified.")
                    ;
    }

    //This is for passing months repayment
    @PostMapping("/api/v1/SmeLoanAccount/localCalculatorInMonths")
    public ResponseEntity<String> calculateLoanByMonths(@RequestBody LoanCalculatorModel loanModel){
        double r = (loanModel.getInterestRate()/100) / 12;
        double n = loanModel.getRepaymentPeriod(); //* 12 if it was in years...

        return ResponseEntity.status(HttpStatus.OK)
                .body("With a loan of $"+ loanModel.getLoanAmount() + " at "+loanModel.getInterestRate() + "% payable for "+ loanModel.getRepaymentPeriod() + " months, \nYou will pay $" + loanModel.getLoanAmount() / ((Math.pow((1 + r), n)-1) / (r * Math.pow((1 + r), n))) + " monthly for the tenure specified.")
                ;
    }

}
