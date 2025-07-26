package com.smartsolutions.eschool.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.smartsolutions.eschool.util.ResourceObject;

import java.util.Map;

public final class SingleResourceSuccessResponseObject {
    // The document's primary data.
    public final ResourceObject data;
    // A meta object that contains non-standard meta-information.
    public final Map<String, Object> meta;

    public SingleResourceSuccessResponseObject(ResourceObject data, Map<String, Object> meta) {
        this.data = data;
        this.meta = meta;
    }

    public SingleResourceSuccessResponseObject(ResourceObject data) {
        this.data = data;
        this.meta = null;
    }

    public ResourceObject getData() {
        return data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, Object> getMeta() {
        return meta;
    }
}
