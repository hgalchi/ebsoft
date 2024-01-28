package com.study.dto;

public class PageOper {

    private int startP, endP;
    private boolean prev,next;
    private int total;
    private PageVo pageVo;

    @Override
    public String toString() {
        return "info"+startP+endP+prev+next+total;
    }

    public PageOper(PageVo vo, int total) {

        this.pageVo = vo;
        this.total = total;

        this.endP = (int)(Math.ceil(pageVo.getPage() / 10.0)) * 10;
        this.startP = this.endP - 9;

        int realEnd = (int)(Math.ceil((total * 1.0)/pageVo.getAmount()));

        if(realEnd < this.endP) {
            this.endP = realEnd;
        }

        this.prev = this.startP > 1;
        this.next = this.endP < realEnd;
    }

    public int getStartP() {
        return startP;
    }

    public void setStartP(int startP) {
        this.startP = startP;
    }

    public int getEndP() {
        return endP;
    }

    public void setEndP(int endP) {
        this.endP = endP;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PageVo getPageVo() {
        return pageVo;
    }

    public void setPageVo(PageVo pageVo) {
        this.pageVo = pageVo;
    }
}
