package com.github.propenster.SmeLoanGiver.Entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bvn",
        "is_blacklisted",
        "account_number",
        "first_name",
        "last_name"
})
public class Data {

    @JsonProperty("bvn")
    private String bvn;
    @JsonProperty("is_blacklisted")
    private Boolean isBlacklisted;
    @JsonProperty("account_number")
    private Boolean accountNumber;
    @JsonProperty("first_name")
    private Boolean firstName;
    @JsonProperty("last_name")
    private Boolean lastName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bvn")
    public String getBvn() {
        return bvn;
    }

    @JsonProperty("bvn")
    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    @JsonProperty("is_blacklisted")
    public Boolean getIsBlacklisted() {
        return isBlacklisted;
    }

    @JsonProperty("is_blacklisted")
    public void setIsBlacklisted(Boolean isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    @JsonProperty("account_number")
    public Boolean getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("account_number")
    public void setAccountNumber(Boolean accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("first_name")
    public Boolean getFirstName() {
        return firstName;
    }

    @JsonProperty("first_name")
    public void setFirstName(Boolean firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("last_name")
    public Boolean getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(Boolean lastName) {
        this.lastName = lastName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bvn", bvn).append("isBlacklisted", isBlacklisted).append("accountNumber", accountNumber).append("firstName", firstName).append("lastName", lastName).append("additionalProperties", additionalProperties).toString();
    }

}
