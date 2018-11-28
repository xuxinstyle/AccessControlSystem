package com.system.po;

import java.util.Date;

public class User {
    private String username;

    private String password;

    private Integer opennum;

    private Date lastopentime;

    private String csvpath;

    private String imagepath;

    private String rolename;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getOpennum() {
        return opennum;
    }

    public void setOpennum(Integer opennum) {
        this.opennum = opennum;
    }

    public Date getLastopentime() {
        
    	return lastopentime;
    }

    public void setLastopentime(Date lastopentime) {
        this.lastopentime = lastopentime;
    }

    public String getCsvpath() {
        return csvpath;
    }

    public void setCsvpath(String csvpath) {
        this.csvpath = csvpath == null ? null : csvpath.trim();
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}