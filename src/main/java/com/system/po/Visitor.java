package com.system.po;

import java.util.Date;

public class Visitor {
    private String vname;

    private Date vtime;

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }
}