
package com.orientalbank.chatbot.json.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "nluIntentConfidence",
    "slots"
})
public class AlternativeIntent {

    @JsonProperty("name")
    private String name;
    @JsonProperty("nluIntentConfidence")
    private Object nluIntentConfidence;
    @JsonProperty("slots")
    private Slots slots;
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

    @JsonProperty("nluIntentConfidence")
    public Object getNluIntentConfidence() {
        return nluIntentConfidence;
    }

    @JsonProperty("nluIntentConfidence")
    public void setNluIntentConfidence(Object nluIntentConfidence) {
        this.nluIntentConfidence = nluIntentConfidence;
    }

    @JsonProperty("slots")
    public Slots getSlots() {
        return slots;
    }

    @JsonProperty("slots")
    public void setSlots(Slots slots) {
        this.slots = slots;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
