
package com.orientalbank.chatbot.json.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "botName",
    "botAlias",
    "botVersion",
    "inputTranscript",
    "botResponse",
    "alternativeIntents",
    "missedUtterance",
    "inputDialogMode",
    "requestId",
    "userId",
    "sessionId",
    "dialogState",
    "responseCard",
    "locale",
    "timestamp",
    "developerOverride",
    "sessionAttributes",
    "messageVersion"
})
public class ChatBotTranscript {

    @JsonProperty("botName")
    private String botName;
    @JsonProperty("botAlias")
    private String botAlias;
    @JsonProperty("botVersion")
    private String botVersion;
    @JsonProperty("inputTranscript")
    private String inputTranscript;
    @JsonProperty("botResponse")
    private String botResponse;
    @JsonProperty("alternativeIntents")
    private List<AlternativeIntent> alternativeIntents = null;
    @JsonProperty("missedUtterance")
    private Boolean missedUtterance;
    @JsonProperty("inputDialogMode")
    private String inputDialogMode;
    @JsonProperty("requestId")
    private String requestId;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("sessionId")
    private String sessionId;
    @JsonProperty("dialogState")
    private String dialogState;
    @JsonProperty("responseCard")
    private ResponseCard responseCard;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("developerOverride")
    private Boolean developerOverride;
    @JsonProperty("sessionAttributes")
    private SessionAttributes sessionAttributes;
    @JsonProperty("messageVersion")
    private String messageVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("botName")
    public String getBotName() {
        return botName;
    }

    @JsonProperty("botName")
    public void setBotName(String botName) {
        this.botName = botName;
    }

    @JsonProperty("botAlias")
    public String getBotAlias() {
        return botAlias;
    }

    @JsonProperty("botAlias")
    public void setBotAlias(String botAlias) {
        this.botAlias = botAlias;
    }

    @JsonProperty("botVersion")
    public String getBotVersion() {
        return botVersion;
    }

    @JsonProperty("botVersion")
    public void setBotVersion(String botVersion) {
        this.botVersion = botVersion;
    }

    @JsonProperty("inputTranscript")
    public String getInputTranscript() {
        return inputTranscript;
    }

    @JsonProperty("inputTranscript")
    public void setInputTranscript(String inputTranscript) {
        this.inputTranscript = inputTranscript;
    }

    @JsonProperty("botResponse")
    public String getBotResponse() {
        return botResponse;
    }

    @JsonProperty("botResponse")
    public void setBotResponse(String botResponse) {
        this.botResponse = botResponse;
    }

    @JsonProperty("alternativeIntents")
    public List<AlternativeIntent> getAlternativeIntents() {
        return alternativeIntents;
    }

    @JsonProperty("alternativeIntents")
    public void setAlternativeIntents(List<AlternativeIntent> alternativeIntents) {
        this.alternativeIntents = alternativeIntents;
    }

    @JsonProperty("missedUtterance")
    public Boolean getMissedUtterance() {
        return missedUtterance;
    }

    @JsonProperty("missedUtterance")
    public void setMissedUtterance(Boolean missedUtterance) {
        this.missedUtterance = missedUtterance;
    }

    @JsonProperty("inputDialogMode")
    public String getInputDialogMode() {
        return inputDialogMode;
    }

    @JsonProperty("inputDialogMode")
    public void setInputDialogMode(String inputDialogMode) {
        this.inputDialogMode = inputDialogMode;
    }

    @JsonProperty("requestId")
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty("requestId")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonProperty("userId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("sessionId")
    public String getSessionId() {
        return sessionId;
    }

    @JsonProperty("sessionId")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("dialogState")
    public String getDialogState() {
        return dialogState;
    }

    @JsonProperty("dialogState")
    public void setDialogState(String dialogState) {
        this.dialogState = dialogState;
    }

    @JsonProperty("responseCard")
    public ResponseCard getResponseCard() {
        return responseCard;
    }

    @JsonProperty("responseCard")
    public void setResponseCard(ResponseCard responseCard) {
        this.responseCard = responseCard;
    }

    @JsonProperty("locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("locale")
    public void setLocale(String locale) {
        this.locale = locale;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("developerOverride")
    public Boolean getDeveloperOverride() {
        return developerOverride;
    }

    @JsonProperty("developerOverride")
    public void setDeveloperOverride(Boolean developerOverride) {
        this.developerOverride = developerOverride;
    }

    @JsonProperty("sessionAttributes")
    public SessionAttributes getSessionAttributes() {
        return sessionAttributes;
    }

    @JsonProperty("sessionAttributes")
    public void setSessionAttributes(SessionAttributes sessionAttributes) {
        this.sessionAttributes = sessionAttributes;
    }

    @JsonProperty("messageVersion")
    public String getMessageVersion() {
        return messageVersion;
    }

    @JsonProperty("messageVersion")
    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
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
