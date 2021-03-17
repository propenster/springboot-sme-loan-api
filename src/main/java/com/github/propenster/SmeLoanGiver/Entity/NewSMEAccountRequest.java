package com.github.propenster.SmeLoanGiver.Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString

@Document(collection = "smeaccounts")
public class NewSMEAccountRequest {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String otherNames;
    private String phoneNumber;
    private String homeAddress;
    private String occupation;
    private String businessName;
    private String businessRcNumber; //is your business registered...CAC api
    private String businessCategory; //create a getALlBusinessCategoryEndpoint...
    private String sizeOfBusiness; //0-10, 11-20, 21-50, etc

    //identification
    private String identificationType;
    private String identificationCard; //in base64-encoded
    private String identificationNumber; //unique number on that ID
    private Date identificationIssuedDate; //date ID issues;
    private Date identificationExpiredDate; //date ID expires...

    //Bank
    private String bankName; //getAllBanks
    private String bankAccountNumber; //account number linked to the BVN
    private String BVN;  //long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    private String bankAccountType; //savings/ current etc

    //Bank Docs
    private String bankStatementSixMonths; //pdf base-64
    private String businessProposal; //business plan this is actually not necessary

    //How much are you requesting...Loan Info
    private BigDecimal requestedLoanAmount; //how much do you want to take...
    private int repaymentPeriod; //how many months are you going to repay... enure..N500K
    private double loanPercent; //4.5%

    //Refereees
    private String referee1FirstName;
    private String referee1LastName;
    private String referee1OtherNames;
    private String referee1PhoneNumber;
    private String referee1Email;
    private String referee1Occupation;
    private String referee1Address;
    private String referee1SignatureDoc; //base64

    private String referee2FirstName;
    private String referee2LastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessRcNumber() {
        return businessRcNumber;
    }

    public void setBusinessRcNumber(String businessRcNumber) {
        this.businessRcNumber = businessRcNumber;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public String getSizeOfBusiness() {
        return sizeOfBusiness;
    }

    public void setSizeOfBusiness(String sizeOfBusiness) {
        this.sizeOfBusiness = sizeOfBusiness;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getIdentificationIssuedDate() {
        return identificationIssuedDate;
    }

    public void setIdentificationIssuedDate(Date identificationIssuedDate) {
        this.identificationIssuedDate = identificationIssuedDate;
    }

    public Date getIdentificationExpiredDate() {
        return identificationExpiredDate;
    }

    public void setIdentificationExpiredDate(Date identificationExpiredDate) {
        this.identificationExpiredDate = identificationExpiredDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBVN() {
        return BVN;
    }

    public void setBVN(String BVN) {
        this.BVN = BVN;
    }

    public String getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public String getBankStatementSixMonths() {
        return bankStatementSixMonths;
    }

    public void setBankStatementSixMonths(String bankStatementSixMonths) {
        this.bankStatementSixMonths = bankStatementSixMonths;
    }

    public String getBusinessProposal() {
        return businessProposal;
    }

    public void setBusinessProposal(String businessProposal) {
        this.businessProposal = businessProposal;
    }

    public BigDecimal getRequestedLoanAmount() {
        return requestedLoanAmount;
    }

    public void setRequestedLoanAmount(BigDecimal requestedLoanAmount) {
        this.requestedLoanAmount = requestedLoanAmount;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public double getLoanPercent() {
        return loanPercent;
    }

    public void setLoanPercent(double loanPercent) {
        this.loanPercent = loanPercent;
    }

    public String getReferee1FirstName() {
        return referee1FirstName;
    }

    public void setReferee1FirstName(String referee1FirstName) {
        this.referee1FirstName = referee1FirstName;
    }

    public String getReferee1LastName() {
        return referee1LastName;
    }

    public void setReferee1LastName(String referee1LastName) {
        this.referee1LastName = referee1LastName;
    }

    public String getReferee1OtherNames() {
        return referee1OtherNames;
    }

    public void setReferee1OtherNames(String referee1OtherNames) {
        this.referee1OtherNames = referee1OtherNames;
    }

    public String getReferee1PhoneNumber() {
        return referee1PhoneNumber;
    }

    public void setReferee1PhoneNumber(String referee1PhoneNumber) {
        this.referee1PhoneNumber = referee1PhoneNumber;
    }

    public String getReferee1Email() {
        return referee1Email;
    }

    public void setReferee1Email(String referee1Email) {
        this.referee1Email = referee1Email;
    }

    public String getReferee1Occupation() {
        return referee1Occupation;
    }

    public void setReferee1Occupation(String referee1Occupation) {
        this.referee1Occupation = referee1Occupation;
    }

    public String getReferee1Address() {
        return referee1Address;
    }

    public void setReferee1Address(String referee1Address) {
        this.referee1Address = referee1Address;
    }

    public String getReferee1SignatureDoc() {
        return referee1SignatureDoc;
    }

    public void setReferee1SignatureDoc(String referee1SignatureDoc) {
        this.referee1SignatureDoc = referee1SignatureDoc;
    }

    public String getReferee2FirstName() {
        return referee2FirstName;
    }

    public void setReferee2FirstName(String referee2FirstName) {
        this.referee2FirstName = referee2FirstName;
    }

    public String getReferee2LastName() {
        return referee2LastName;
    }

    public void setReferee2LastName(String referee2LastName) {
        this.referee2LastName = referee2LastName;
    }

    public String getReferee2OtherNames() {
        return referee2OtherNames;
    }

    public void setReferee2OtherNames(String referee2OtherNames) {
        this.referee2OtherNames = referee2OtherNames;
    }

    public String getReferee2PhoneNumber() {
        return referee2PhoneNumber;
    }

    public void setReferee2PhoneNumber(String referee2PhoneNumber) {
        this.referee2PhoneNumber = referee2PhoneNumber;
    }

    public String getReferee2Email() {
        return referee2Email;
    }

    public void setReferee2Email(String referee2Email) {
        this.referee2Email = referee2Email;
    }

    public String getReferee2Occupation() {
        return referee2Occupation;
    }

    public void setReferee2Occupation(String referee2Occupation) {
        this.referee2Occupation = referee2Occupation;
    }

    public String getReferee2Address() {
        return referee2Address;
    }

    public void setReferee2Address(String referee2Address) {
        this.referee2Address = referee2Address;
    }

    public String getReferee2SignatureDoc() {
        return referee2SignatureDoc;
    }

    public void setReferee2SignatureDoc(String referee2SignatureDoc) {
        this.referee2SignatureDoc = referee2SignatureDoc;
    }

    public boolean isAcceptedTermsAndAgreements() {
        return acceptedTermsAndAgreements;
    }

    public void setAcceptedTermsAndAgreements(boolean acceptedTermsAndAgreements) {
        this.acceptedTermsAndAgreements = acceptedTermsAndAgreements;
    }

    private String referee2OtherNames;
    private String referee2PhoneNumber;
    private String referee2Email;
    private String referee2Occupation;
    private String referee2Address;
    private String referee2SignatureDoc; //base64


    //terms
    private boolean acceptedTermsAndAgreements;

    //private String
    private long AccountNumber;

    public void setAccountNumber(long accountNumber) {
        this.AccountNumber = accountNumber;
    }

    public long getAccountNumber(){
        return this.AccountNumber;
    }


}

