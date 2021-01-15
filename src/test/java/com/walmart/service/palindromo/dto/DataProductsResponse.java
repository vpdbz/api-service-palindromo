package com.walmart.service.palindromo.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.platform.response.BaseResponse;
import com.walmart.service.palindromo.model.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataProductsResponse extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty
    protected List<Product> data;

    /**
     * Add a single object such as user, certificate, organziation
     * 
     * @param value
     */
    public void setReturnData(List<Product> value) {
        data = value;
    }

    /**
     * Return a list of objects
     * @return
     */
    public List<Product> getData() {
    	return data;
    }
    
    @Override
    public String toString() {

        return "DataResponse [success=" + getSuccess() + ", status=" + getStatus() + ", message="
                + getMessage() + ", data =" + data + "]";
    }

}