package com.jackson.example.firstday.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class BookPOJO
{
    private String title;
    private boolean inprint;
    @JsonProperty("publish_date")
    private LocalDate publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInprint() {
        return inprint;
    }

    public void setInprint(boolean inprint) {
        this.inprint = inprint;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
