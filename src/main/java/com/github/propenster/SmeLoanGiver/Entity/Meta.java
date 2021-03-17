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
        "calls_this_month",
        "free_calls_left"
})
public class Meta {

    @JsonProperty("calls_this_month")
    private Integer callsThisMonth;
    @JsonProperty("free_calls_left")
    private Integer freeCallsLeft;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("calls_this_month")
    public Integer getCallsThisMonth() {
        return callsThisMonth;
    }

    @JsonProperty("calls_this_month")
    public void setCallsThisMonth(Integer callsThisMonth) {
        this.callsThisMonth = callsThisMonth;
    }

    @JsonProperty("free_calls_left")
    public Integer getFreeCallsLeft() {
        return freeCallsLeft;
    }

    @JsonProperty("free_calls_left")
    public void setFreeCallsLeft(Integer freeCallsLeft) {
        this.freeCallsLeft = freeCallsLeft;
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
        return new ToStringBuilder(this).append("callsThisMonth", callsThisMonth).append("freeCallsLeft", freeCallsLeft).append("additionalProperties", additionalProperties).toString();
    }

}
