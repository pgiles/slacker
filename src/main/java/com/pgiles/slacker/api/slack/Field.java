package com.pgiles.slacker.api.slack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "value",
    "short"
})
public class Field implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("value")
    private String value;
    @JsonProperty("short")
    private Boolean _short;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6770127535794484833L;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Field withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Field withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("short")
    public Boolean getShort() {
        return _short;
    }

    @JsonProperty("short")
    public void setShort(Boolean _short) {
        this._short = _short;
    }

    public Field withShort(Boolean _short) {
        this._short = _short;
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(title).append(additionalProperties).append(_short).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Field) == false) {
            return false;
        }
        Field rhs = ((Field) other);
        return new EqualsBuilder().append(title, rhs.title).append(additionalProperties, rhs.additionalProperties).append(_short, rhs._short).append(value, rhs.value).isEquals();
    }

}
