package com.github.propenster.SmeLoanGiver.Entity.PaystackBank;

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
        "next",
        "previous",
        "perPage"
})
public class Meta {

    @JsonProperty("next")
    private Integer next;
    @JsonProperty("previous")
    private Integer previous;
    @JsonProperty("perPage")
    private Integer perPage;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("next")
    public Integer getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(Integer next) {
        this.next = next;
    }

    @JsonProperty("previous")
    public Integer getPrevious() {
        return previous;
    }

    @JsonProperty("previous")
    public void setPrevious(Integer previous) {
        this.previous = previous;
    }
    @JsonProperty("perPage")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("perPage")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
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
        return new ToStringBuilder(this).append("next", next).append("previous", previous).append("perPage", perPage).append("additionalProperties", additionalProperties).toString();
    }
}
