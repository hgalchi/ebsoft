package com.study.dto;

public class PageVo {

    private int page,amount;

    public PageVo() {
        this(0, 10);
    }

    public PageVo(int page, int amount) {
        this.page = page;
        this.amount=amount;
    }

    public int getskip() {
        return (page-1)*amount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
