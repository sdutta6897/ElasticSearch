
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
    "title",
    "subTitle",
    "buttons",
    "imageUrl",
    "attachmentLinkUrl"
})
public class GenericAttachment {

    @JsonProperty("title")
    private Object title;
    @JsonProperty("subTitle")
    private Object subTitle;
    @JsonProperty("buttons")
    private List<Button> buttons = null;
    @JsonProperty("imageUrl")
    private Object imageUrl;
    @JsonProperty("attachmentLinkUrl")
    private Object attachmentLinkUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public Object getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Object title) {
        this.title = title;
    }

    @JsonProperty("subTitle")
    public Object getSubTitle() {
        return subTitle;
    }

    @JsonProperty("subTitle")
    public void setSubTitle(Object subTitle) {
        this.subTitle = subTitle;
    }

    @JsonProperty("buttons")
    public List<Button> getButtons() {
        return buttons;
    }

    @JsonProperty("buttons")
    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    @JsonProperty("imageUrl")
    public Object getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("attachmentLinkUrl")
    public Object getAttachmentLinkUrl() {
        return attachmentLinkUrl;
    }

    @JsonProperty("attachmentLinkUrl")
    public void setAttachmentLinkUrl(Object attachmentLinkUrl) {
        this.attachmentLinkUrl = attachmentLinkUrl;
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
