package com.dbp.demo01.model;

public class Book{
    private int bookId;
    private String name;
    private int type;
    private String company;

    public int getBookId() {
        return bookId;
    }

    public void setbookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
