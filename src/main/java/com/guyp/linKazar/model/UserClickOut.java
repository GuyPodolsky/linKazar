package com.guyp.linKazar.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guyp.linKazar.util.Dates;
import org.joda.time.LocalDateTime;

import java.util.Date;

public class UserClickOut {

    private String userName;
    private Date clickTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("clickTime")
    public LocalDateTime calcClickTime() {
        return Dates.atLocalTime(clickTime);
    }

    private String tiny;
    private String longUrl;

    public String getUserName() {
        return userName;
    }

    public Date getClickTime() {
        return clickTime;
    }

    public String getTiny() {
        return tiny;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public static UserClickOut of(UserClick userClick) {
        UserClickOut res = new UserClickOut();
        res.userName = userClick.getUserClickKey().getUserName();
        res.clickTime = userClick.getUserClickKey().getClickTime();
        res.tiny = userClick.getTiny();
        res.longUrl = userClick.getLongUrl();
        return res;
    }
}