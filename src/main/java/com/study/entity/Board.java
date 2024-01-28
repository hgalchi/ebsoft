package com.study.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.now;

public class Board {

    private int id;
    private String pw;
    private String writer;
    private String title;
    private String content;
    private int view;
    private LocalDateTime created_date;
    private LocalDateTime modified_date;
    private int category;

    public Board() {

    }

    public Board(int category,String writer,String pw,String title,String content) {
        this.category = category;
        this.writer=writer;
        this.pw = pw;
        this.title=title;
        this.content = content;
        view=0;
        created_date = LocalDateTime.now();
        modified_date = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return id+writer+content+title+created_date+modified_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getModified_date() {
        return modified_date;
    }

    public void setModified_date(LocalDateTime modified_date) {
        this.modified_date = modified_date;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


}
