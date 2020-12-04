package edu.gq.bbpic.pojo;

import java.util.Date;

public class PicList {
    private Integer picListId;

    private Integer userId;

    private Integer categoryId;

    private String picListName;

    private String intro;

    private Integer collectNum;

    private Integer heat;

    private Integer enable;

    private Date creationTime;

    public PicList(Integer picListId, Integer userId, Integer categoryId, String picListName, String intro, Integer collectNum, Integer heat, Integer enable, Date creationTime) {
        this.picListId = picListId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.picListName = picListName;
        this.intro = intro;
        this.collectNum = collectNum;
        this.heat = heat;
        this.enable = enable;
        this.creationTime = creationTime;
    }

    public PicList() {
        super();
    }

    public Integer getPicListId() {
        return picListId;
    }

    public void setPicListId(Integer picListId) {
        this.picListId = picListId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getPicListName() {
        return picListName;
    }

    public void setPicListName(String picListName) {
        this.picListName = picListName == null ? null : picListName.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
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
}