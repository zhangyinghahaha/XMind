package com.demo;

import java.util.Date;

/**
 * @author ying.zhang01
 */
public class QueryParams {
    private int pi = 1;
    private int ps = 10;
    private Date start = new Date();
    private Date end;

    public int getPi() {
        return pi;
    }

    public void setPi(int pi) {
        this.pi = pi;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
