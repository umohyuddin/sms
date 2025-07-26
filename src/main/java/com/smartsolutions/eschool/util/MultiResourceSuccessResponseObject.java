package com.smartsolutions.eschool.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

public final class MultiResourceSuccessResponseObject<T> {
    // The document's primary data
    public final List<T> data;
    // A meta object that contains non-standard meta-information.
    public final Map<String, Object> meta;

    public MultiResourceSuccessResponseObject(List<T> data, Map<String, Object> meta) {
        this.data = data;
        this.meta = meta;
    }

    public MultiResourceSuccessResponseObject(List<T> data) {
        this.data = data;
        this.meta = null;
    }

    public List<T> getData() {
        return data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Map<String, Object> getMeta() {
        return meta;
    }
}
