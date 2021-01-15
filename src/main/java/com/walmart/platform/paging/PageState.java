/**
 * Copyright (c) 2017 by Sovos Compliance
 */
package com.walmart.platform.paging;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Represents paging details for both request and response.
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageState implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PAGE_STATE = "pageState";

    /* Requested page to be returned (zero based) */
    private Integer page = 0;

    /* Requested number of entries per page to be returned */
    private Integer perPage = 50;

    /* the total number of page = # of records / perPage */
    private Integer totalPages = 0;

    /* the total number of records */
    private Long totalEntries = 0L;

    private String order;

    private String sortBy;

    /**
     * Default constructor for the Page State.
     */
    public PageState() {
        this.order = null;
        this.sortBy = null;
    }

    /**
     * @param page
     * @param perPage
     */
    public PageState(Integer page, Integer perPage) {
        this.page = page;
        this.perPage = perPage;
    }

    /**
     * @return the page
     */
    public Integer getPage() {

        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(Integer page) {

        this.page = page;
    }

    /**
     * @return the perPage
     */
    public Integer getPerPage() {

        return perPage;
    }

    /**
     * @param perPage the perPage to set
     */
    public void setPerPage(Integer perPage) {

        this.perPage = perPage;
    }

    /**
     * @return the totalPages
     */
    public Integer getTotalPages() {

        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(Integer totalPages) {

        this.totalPages = totalPages;
    }

    /**
     * @return the totalEntries
     */
    public Long getTotalEntries() {

        return totalEntries;
    }

    /**
     * @param totalEntries the totalEntries to set
     */
    public void setTotalEntries(Long totalEntries) {

        this.totalEntries = totalEntries;
    }

    /**
     * Get the sort by setting for the page.
     * 
     * @return
     */
    public String getSortBy() {

        return sortBy;
    }

    /**
     * Set the sort by setting for the page.
     * 
     * @param sortBy Setting for the page.
     */
    public void setSortBy(String sortBy) {

        this.sortBy = sortBy;
    }

    /**
     * Get the order for the page.
     * 
     * @return the order for the page.
     */
    public String getOrder() {

        return order;
    }

    /**
     * Set the order for the page.
     * 
     * @param order The order for the page.
     */
    public void setOrder(String order) {

        this.order = order;
    }

}