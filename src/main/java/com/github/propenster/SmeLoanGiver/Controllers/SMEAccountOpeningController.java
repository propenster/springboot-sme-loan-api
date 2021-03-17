package com.github.propenster.SmeLoanGiver.Controllers;

import com.github.propenster.SmeLoanGiver.Entity.NewSMEAccountRequest;
import com.github.propenster.SmeLoanGiver.Entity.PaystackBank.Paystack;
import com.github.propenster.SmeLoanGiver.Repository.SMEAccountOpeningRepository;
import com.github.propenster.SmeLoanGiver.Utilities.PaystackRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
public class SMEAccountOpeningController {

    @Autowired
    private SMEAccountOpeningRepository repository;

    @Autowired
    private PaystackRestClient restClient;

    @GetMapping("/api/v1/SmeLoanAccount/getSmeAccountById/{id}")
    public Optional<NewSMEAccountRequest> getSmeAccountById(@PathVariable String id){
        return repository.findById(id);

    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllSmeAccounts")
    public List<NewSMEAccountRequest> getAllSmeAccounts(){
        return repository.findAll();
    }

    @GetMapping("/api/v1/SmeLoanAccount/getSmeAccountByAccountNumber")
    public Optional<NewSMEAccountRequest> getSmeAccountByAccountNumber(@RequestParam(value = "AccountNumber") long AccountNumber){
    return repository.findByAccountNumber(AccountNumber);
    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllBanks")
    public Paystack GetAllBanks()
    {
        return restClient.getAllBanks();
    }

    @PutMapping("/api/v1/SmeLoanAccount/updateSmeAccount")
    public NewSMEAccountRequest updateSmeAccount(@RequestBody NewSMEAccountRequest account){

            NewSMEAccountRequest existingAccount = repository.findById(account.getId()).orElse(null);
            existingAccount.setFirstName(account.getFirstName());
            existingAccount.setLastName(account.getLastName());
            existingAccount.setOtherNames(account.getOtherNames());
            existingAccount.setPhoneNumber(account.getPhoneNumber());
            existingAccount.setHomeAddress(account.getHomeAddress());
            existingAccount.setOccupation(account.getOccupation());
            existingAccount.setBusinessName(account.getBusinessName());
            existingAccount.setBusinessRcNumber(account.getBusinessRcNumber());
            existingAccount.setBusinessCategory(account.getBusinessCategory());
            existingAccount.setSizeOfBusiness(account.getSizeOfBusiness());
            existingAccount.setIdentificationType(account.getIdentificationType());
            existingAccount.setIdentificationCard(encodeFileToBase64(account.getIdentificationCard()));
            existingAccount.setIdentificationNumber(account.getIdentificationNumber());
            existingAccount.setIdentificationIssuedDate(account.getIdentificationIssuedDate());
            existingAccount.setIdentificationExpiredDate(account.getIdentificationExpiredDate());
            existingAccount.setBankName(account.getBankName());
            existingAccount.setBankAccountNumber(account.getBankAccountNumber());
            existingAccount.setBVN(account.getBVN());
            existingAccount.setBankAccountType(account.getBankAccountType());
            existingAccount.setBankStatementSixMonths(encodeFileToBase64(account.getBankStatementSixMonths()));//file encodeTobase64
            existingAccount.setBusinessProposal(encodeFileToBase64(account.getBusinessProposal()));
            existingAccount.setRequestedLoanAmount(account.getRequestedLoanAmount()); //should user be able to edit this?
            existingAccount.setRepaymentPeriod(account.getRepaymentPeriod());
            existingAccount.setLoanPercent(account.getLoanPercent());
            existingAccount.setReferee1FirstName(account.getReferee1FirstName());
            existingAccount.setReferee1LastName(account.getReferee1LastName());
            existingAccount.setReferee1OtherNames(account.getReferee1OtherNames());
            existingAccount.setReferee1PhoneNumber(account.getReferee1PhoneNumber());
            existingAccount.setReferee1Email(account.getReferee1Email());
            existingAccount.setReferee1Occupation(account.getReferee1Occupation());
            existingAccount.setReferee1Address(account.getReferee1Address());
            existingAccount.setReferee1SignatureDoc(encodeFileToBase64(account.getReferee1SignatureDoc()));

            existingAccount.setReferee2FirstName(account.getReferee2FirstName());
            existingAccount.setReferee2LastName(account.getReferee2LastName());
            existingAccount.setReferee2OtherNames(account.getReferee2OtherNames());
            existingAccount.setReferee2PhoneNumber(account.getReferee2PhoneNumber());
            existingAccount.setReferee2Email(account.getReferee2Email());
            existingAccount.setReferee2Occupation(account.getReferee2Occupation());
            existingAccount.setReferee2Address(account.getReferee2Address());
            existingAccount.setReferee2SignatureDoc(encodeFileToBase64(account.getReferee2SignatureDoc()));
            //he should not change his accountNumber
            existingAccount.setAcceptedTermsAndAgreements(account.isAcceptedTermsAndAgreements());

            return repository.save(existingAccount);


//        return "Account Updated Successfully!";
    }

    @PostMapping("/api/v1/SmeLoanAccount/newAccount")
    public String createNewSMEAccount(@RequestBody NewSMEAccountRequest request){

        NewSMEAccountRequest dto = new NewSMEAccountRequest();
        dto.setFirstName(request.getFirstName());
        dto.setLastName(request.getLastName());
        dto.setOtherNames(request.getOtherNames());
        dto.setPhoneNumber(request.getPhoneNumber());
        dto.setHomeAddress(request.getHomeAddress());
        dto.setOccupation(request.getOccupation());
        dto.setBusinessName(request.getBusinessName());
        dto.setBusinessRcNumber(request.getBusinessRcNumber());
        dto.setBusinessCategory(request.getBusinessCategory());
        dto.setSizeOfBusiness(request.getSizeOfBusiness());
        dto.setIdentificationType(request.getIdentificationType());
        dto.setIdentificationCard(encodeFileToBase64(request.getIdentificationCard()));
        dto.setIdentificationNumber(request.getIdentificationNumber());
        dto.setIdentificationIssuedDate(request.getIdentificationIssuedDate());
        dto.setIdentificationExpiredDate(request.getIdentificationExpiredDate());
        dto.setBankName(request.getBankName());
        dto.setBankAccountNumber(request.getBankAccountNumber());
        dto.setBVN(request.getBVN());
        dto.setBankAccountType(request.getBankAccountType());
        dto.setBankStatementSixMonths(encodeFileToBase64(request.getBankStatementSixMonths()));//file encodeTobase64
        dto.setBusinessProposal(encodeFileToBase64(request.getBusinessProposal()));
        dto.setRequestedLoanAmount(request.getRequestedLoanAmount());
        dto.setRepaymentPeriod(request.getRepaymentPeriod());
        dto.setLoanPercent(request.getLoanPercent());
        dto.setReferee1FirstName(request.getReferee1FirstName());
        dto.setReferee1LastName(request.getReferee1LastName());
        dto.setReferee1OtherNames(request.getReferee1OtherNames());
        dto.setReferee1PhoneNumber(request.getReferee1PhoneNumber());
        dto.setReferee1Email(request.getReferee1Email());
        dto.setReferee1Occupation(request.getReferee1Occupation());
        dto.setReferee1Address(request.getReferee1Address());
        dto.setReferee1SignatureDoc(encodeFileToBase64(request.getReferee1SignatureDoc()));

        dto.setReferee2FirstName(request.getReferee2FirstName());
        dto.setReferee2LastName(request.getReferee2LastName());
        dto.setReferee2OtherNames(request.getReferee2OtherNames());
        dto.setReferee2PhoneNumber(request.getReferee2PhoneNumber());
        dto.setReferee2Email(request.getReferee2Email());
        dto.setReferee2Occupation(request.getReferee2Occupation());
        dto.setReferee2Address(request.getReferee2Address());
        dto.setReferee2SignatureDoc(encodeFileToBase64(request.getReferee2SignatureDoc()));

        dto.setAcceptedTermsAndAgreements(request.isAcceptedTermsAndAgreements());
        dto.setAccountNumber((long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);
        //now save the DTO
        repository.save(dto);

        return "You have successfully created a new SME Loan Account\n We will review your application and get back to you.\n Your AccountNumber is : " + dto.getAccountNumber();
        //long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;

    }

    public static String encodeFileToBase64(String filePath) {
        String base64File = "";
        File file = new File(filePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return base64File;
    } //end encoder static class here...
}
