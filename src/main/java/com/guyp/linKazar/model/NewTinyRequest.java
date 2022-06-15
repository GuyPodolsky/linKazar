package com.guyp.linKazar.model;

import org.hibernate.validator.constraints.URL;

public class NewTinyRequest {

    private String userName;
    @URL
    private String longUrl;

    public String getUserName() {
        return userName;
    }

    public String getLongUrl() {
        return longUrl;
    }
}
