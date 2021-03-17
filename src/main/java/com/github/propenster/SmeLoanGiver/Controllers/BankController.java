package com.github.propenster.SmeLoanGiver.Controllers;

import com.github.propenster.SmeLoanGiver.Entity.Accounts.ResolveAccountNumberResponse;
import com.github.propenster.SmeLoanGiver.Entity.Bank;
import com.github.propenster.SmeLoanGiver.Entity.Bvn.ResolveBvnResponse;
import com.github.propenster.SmeLoanGiver.Entity.BvnRequest;
import com.github.propenster.SmeLoanGiver.Entity.BvnResponse;
import com.github.propenster.SmeLoanGiver.Repository.BankRepository;
import com.github.propenster.SmeLoanGiver.Utilities.PaystackRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankController {

    @Autowired
    private BankRepository repository;

    @Autowired
    private PaystackRestClient restClient;

    @GetMapping("/api/v1/SmeLoanAccount/getAllMongoBanks")
    public List<Bank> getAllBanks(){
        return repository.findAll();
    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllMongoBanks/getBankById")
    public Optional<Bank> getBankById(@RequestParam(value = "_id") String _id){
        return repository.findById(_id);
    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllMongoBanks/getBankByBankCode")
    public Optional<Bank> getBankByCode(@RequestParam(value = "code") String code){
        return repository.findByCode(code);
    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllMongoBanks/getBankByCustomId")
    public Optional<Bank> getBankByCustomId(@RequestParam(value = "id") int id){
        return repository.findById(id);
    }

    @GetMapping("/api/v1/SmeLoanAccount/getAllMongoBanks/byCountry")
    public List<Bank> getBanksByCountry(@RequestParam(value = "country") String country){
        return repository.findByCountry(country);
    }

    @PostMapping("/api/v1/SmeLoanAccount/verifyBvn")
    public BvnResponse verifyBvn(@RequestBody BvnRequest request){
        return restClient.verifyBvn(request);
    }

    @GetMapping("/api/v1/SmeLoanAccount/resolveBvn")
    public ResolveBvnResponse resolveBvn(@RequestParam(value = "bvn") String bvn){
        return restClient.resolveBvn(bvn);
    }

    @GetMapping("/api/v1/SmeLoanAccount/resolveAccountNumber")
    public ResolveAccountNumberResponse resolveAccountNumber(@RequestParam(value = "account_number") String account_number, @RequestParam(value = "bank_code") String bank_code){
        return restClient.resolveAccountNumber(account_number, bank_code);
    }

}
