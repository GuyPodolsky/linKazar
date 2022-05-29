package com.handson.tinyurl.model;

import org.hibernate.validator.constraints.URL;

public class NewTinyRequest {
    @URL
    private String longUrl;

    public NewTinyRequest() {
        super();
    }

    public NewTinyRequest(@URL String longUrl) {
        this.longUrl = longUrl;
    }

    public void setLongUrl(@URL String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
