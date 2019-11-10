package com.yyh.tdhy.po;

public class Navigation {
    private Integer id;

    private String navname;

    private String navicon;

    private Integer pid;

    private String url;

    private Integer sort;

    private Integer isshow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNavname() {
        return navname;
    }

    public void setNavname(String navname) {
        this.navname = navname == null ? null : navname.trim();
    }

    public String getNavicon() {
        return navicon;
    }

    public void setNavicon(String navicon) {
        this.navicon = navicon == null ? null : navicon.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsshow() {
        return isshow;
    }

    public void setIsshow(Integer isshow) {
        this.isshow = isshow;
    }
}