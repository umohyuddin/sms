package com.smartsolutions.eschool.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public final class ResourceObject {
    // A unique identifier for this particular resource. (Allowed null if being created).
    private final String id;
    // A type of the resource.
    private final String type;
    // An attributes object representing some of the resource’s data.
    private final Map<String, Object> attributes;

    private Map<String, String> meta;

    @JsonCreator
    public ResourceObject(
            @JsonProperty("id")
            String id,
            @JsonProperty("type")
            String type,
            @JsonProperty("attributes")
            Map<String, Object> attributes) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
    }

    public ResourceObject(
            String id,
            String type,
            Map<String, Object> attributes,
            Map<String, String> meta) {
        this(id, type, attributes);
        this.meta = meta;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, String> getMeta() {
        return meta;
    }
}
