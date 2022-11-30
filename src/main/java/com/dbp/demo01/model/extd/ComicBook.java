package com.dbp.demo01.model.extd;

import com.dbp.demo01.model.Book;

public class ComicBook extends Book{
    int bookId;
    String name;
    int type;
    String company;

    public int getBookId(){
        return this.bookId;
    }
    public void setBookId(int bookId){
        this.bookId=bookId;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type=type;
    }
    public String getCompany(){
        return this.company;
    }
    public void setCompany(String company){
        this.company=company;
    }
}
