package edu.gq.bbpic.pojo;

import java.util.Date;

public class Category {
    private Integer categoryId;

    private String categoryName;

    private String signUrl;

    private Date creationTime;

    public Category(Integer categoryId, String categoryName, String signUrl, Date creationTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.signUrl = signUrl;
        this.creationTime = creationTime;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl == null ? null : signUrl.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}