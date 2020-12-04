package edu.gq.bbpic.vo;

import edu.gq.bbpic.pojo.Category;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import edu.gq.bbpic.pojo.User;

import java.util.Date;
import java.util.List;

public class PicListVo {
    private Integer picListId;

    private String picListName;

    private String intro;

    private Integer collectNum;

    private Integer heat;

    private Date creationTime;

    private Category category;

    private User user;

    private List<Picture> pictures;

    public PicListVo(){

    }

    public Integer getPicListId() {
        return picListId;
    }

    public void setPicListId(Integer picListId) {
        this.picListId = picListId;
    }

    public String getPicListName() {
        return picListName;
    }

    public void setPicListName(String picListName) {
        this.picListName = picListName;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}