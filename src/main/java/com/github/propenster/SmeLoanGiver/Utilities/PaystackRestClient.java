package com.github.propenster.SmeLoanGiver.Utilities;


import com.github.propenster.SmeLoanGiver.Entity.Accounts.ResolveAccountNumberResponse;
import com.github.propenster.SmeLoanGiver.Entity.Bvn.ResolveBvnResponse;
import com.github.propenster.SmeLoanGiver.Entity.BvnRequest;
import com.github.propenster.SmeLoanGiver.Entity.BvnResponse;
import com.github.propenster.SmeLoanGiver.Entity.PaystackBank.Paystack;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@Component
public class PaystackRestClient {

    @Value("${paystack.banks.url}")
    String paystackBanksAPIUrl;

    @Value("${paystack.auth.secret.key}")
    String paystackAuthSecretKey;

    @Value("${paystack.bvn.url}")
    String paystackBvnUrl;

    @Value("${paystack.bvn.resolvebvn.url}")
    String paystackResolveBvnUrl;

    @Value("${paystack.accounts.resolveaccount.url}")
    String paystackResolveAccountUrl;

    RestTemplate restTemplate;

    public PaystackRestClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    public Paystack getAllBanks(){
        Paystack paystackBanks = null;
        try {
            URI uri;
            uri = new URI(paystackBanksAPIUrl);
            //define headers..
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer "+paystackAuthSecretKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<Paystack> totalEntity = restTemplate.exchange(uri, HttpMethod.GET, request, Paystack.class);
            paystackBanks = totalEntity.getBody();

        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

        return paystackBanks;
    }

    public BvnResponse verifyBvn(BvnRequest request){
        BvnResponse bvnResponse = null;

        try {

            URI uri;
            uri = new URI(paystackBvnUrl);

            //headers
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer "+paystackAuthSecretKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            //define
            //MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//            body.add("bvn", request.getBvn().toString());
//            body.add("account_number", request.getAccount_number().toString());
//            body.add("bank_code", request.getBank_code().toString());
//            body.add("first_name", request.getFirst_name().toString());
//            body.add("last_name", request.getLast_name());

            HttpEntity<BvnRequest> requestEntity = new HttpEntity<>(request, headers);

            //
            ResponseEntity<BvnResponse> response = restTemplate.postForEntity(uri, requestEntity, BvnResponse.class);
            bvnResponse = response.getBody();
            System.out.println(response.getBody());

        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

        return bvnResponse;
    }

    public ResolveBvnResponse resolveBvn(String bvn){
        ResolveBvnResponse resolveBvnResponse = null;

        try {
            URI uri;
            uri = new URI(paystackResolveBvnUrl);

            //define headers..
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer "+paystackAuthSecretKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<ResolveBvnResponse> responseEntity = restTemplate.exchange(uri + "/"+bvn, HttpMethod.GET, request, ResolveBvnResponse.class);
            resolveBvnResponse = responseEntity.getBody();

        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

        return resolveBvnResponse;
    }

    public ResolveAccountNumberResponse resolveAccountNumber(String account_number, String bank_code){
        ResolveAccountNumberResponse resolveAccountNumberResponse = null;
        try {
                URI uri;
                uri = new URI(paystackResolveAccountUrl);
                //headers
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer "+paystackAuthSecretKey);
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

                HttpEntity<String> request = new HttpEntity<>(headers);
                ResponseEntity<ResolveAccountNumberResponse> responseEntity = restTemplate.exchange(uri + "?account_number=" + account_number + "&bank_code=" + bank_code, HttpMethod.GET, request, ResolveAccountNumberResponse.class);
                resolveAccountNumberResponse = responseEntity.getBody();

        }catch (URISyntaxException ex){
            ex.printStackTrace();
        }

        return resolveAccountNumberResponse;
    }



}
