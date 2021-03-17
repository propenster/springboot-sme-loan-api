package com.github.propenster.SmeLoanGiver.Authentication.Payloads.Request;

import com.github.propenster.SmeLoanGiver.Entity.NewSMEAccountRequest;

public class UserMakeSmeAccountRequest {

    private String username;
    private String email;
    private NewSMEAccountRequest sme_account;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NewSMEAccountRequest getSme_account() {
        return sme_account;
    }

    public void setSme_account(NewSMEAccountRequest sme_account) {
        this.sme_account = sme_account;
    }
}
