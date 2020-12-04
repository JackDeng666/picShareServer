package edu.gq.bbpic.pojo;

import java.util.Date;

public class Picture {
    private Integer pictureId;

    private Integer picListId;

    private Integer categoryId;

    private Integer userId;

    private String thumbnailUrl;

    private String odUrl;

    private Integer praiseNum;

    private Integer collectNum;

    private Integer enable;

    private Date creationTime;

    private Integer heat;

    public Picture(Integer pictureId, Integer picListId, Integer categoryId, Integer userId, String thumbnailUrl, String odUrl, Integer praiseNum, Integer collectNum, Integer enable, Date creationTime, Integer heat) {
        this.pictureId = pictureId;
        this.picListId = picListId;
        this.categoryId = categoryId;
        this.userId = userId;
        this.thumbnailUrl = thumbnailUrl;
        this.odUrl = odUrl;
        this.praiseNum = praiseNum;
        this.collectNum = collectNum;
        this.enable = enable;
        this.creationTime = creationTime;
        this.heat = heat;
    }

    public Picture() {
        super();
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPicListId() {
        return picListId;
    }

    public void setPicListId(Integer picListId) {
        this.picListId = picListId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl == null ? null : thumbnailUrl.trim();
    }

    public String getOdUrl() {
        return odUrl;
    }

    public void setOdUrl(String odUrl) {
        this.odUrl = odUrl == null ? null : odUrl.trim();
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }
}