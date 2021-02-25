package com.jackson.example.firstday.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthorPOJO
{
    @JsonProperty("author_name")
    private String authorName;
    private List<BookPOJO> books;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookPOJO> getBooks() {
        return books;
    }

    public void setBooks(List<BookPOJO> books) {
        this.books = books;
    }
}
