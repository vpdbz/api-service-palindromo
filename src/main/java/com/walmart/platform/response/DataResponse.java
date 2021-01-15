/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.platform.paging.PageState;


/**
 * Basic response most json response { message : "some message", success : true
 * or false, status : 200 or 401 or 500 or etc data : {
 * 
 * } }
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ITEMS_ELEMENT = "items";
    private static final String PAGE_STATE = "pageState";

    @JsonProperty
    protected Object data;

    /**
     * Add a single object such as user, certificate, organziation
     * 
     * @param value
     */
    public void setReturnData(Object value) {

        data = value;
    }

    /**
     * Add a list of objects such as users, organizations and a list of
     * exemptions
     * 
     * @param list
     */
    public void setReturnList(Object list) {

        setReturnList(list, null);
    }

    /**
     * Add a list of objects such as users, organizations and a list of
     * exemptions
     * 
     * @param list
     * @param pageState
     */
    public void setReturnList(Object list, PageState pageState) {

        Map<String, Object> items = new HashMap<String, Object>();
        items.put(ITEMS_ELEMENT, list);

        if (pageState != null) {
            items.put(PAGE_STATE, pageState);
        }
        data = items;
    }

    @Override
    public String toString() {

        return "DataResponse [success=" + getSuccess() + ", status=" + getStatus() + ", message="
                + getMessage() + ", data =" + data + "]";
    }

}