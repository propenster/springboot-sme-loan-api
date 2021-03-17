package com.github.propenster.SmeLoanGiver.Entity.PaystackBank;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "slug",
        "code",
        "longcode",
        "gateway",
        "pay_with_bank",
        "active",
        "is_deleted",
        "country",
        "currency",
        "type",
        "id",
        "createdAt",
        "updatedAt"
})
public class Datum {

    @JsonProperty("name")
    private String name;
    @JsonProperty("slug")
    private String slug;
    @JsonProperty("code")
    private String code;
    @JsonProperty("longcode")
    private String longcode;
    @JsonProperty("gateway")
    private Object gateway;
    @JsonProperty("pay_with_bank")
    private Boolean payWithBank;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;
    @JsonProperty("country")
    private String country;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("slug")
    public String getSlug() {
        return slug;
    }

    @JsonProperty("slug")
    public void setSlug(String slug) {
        this.slug = slug;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("longcode")
    public String getLongcode() {
        return longcode;
    }

    @JsonProperty("longcode")
    public void setLongcode(String longcode) {
        this.longcode = longcode;
    }

    @JsonProperty("gateway")
    public Object getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(Object gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("pay_with_bank")
    public Boolean getPayWithBank() {
        return payWithBank;
    }

    @JsonProperty("pay_with_bank")
    public void setPayWithBank(Boolean payWithBank) {
        this.payWithBank = payWithBank;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("is_deleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("is_deleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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
        return new ToStringBuilder(this).append("name", name).append("slug", slug).append("code", code).append("longcode", longcode).append("gateway", gateway).append("payWithBank", payWithBank).append("active", active).append("isDeleted", isDeleted).append("country", country).append("currency", currency).append("type", type).append("id", id).append("createdAt", createdAt).append("updatedAt", updatedAt).append("additionalProperties", additionalProperties).toString();
    }

}