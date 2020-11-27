package edu.gq.bbpic.pojo;

import java.util.Date;

public class Praise {
    private Integer userId;

    private Integer pictureId;

    private Integer isCancel;

    private Date creationTime;

    public Praise(Integer userId, Integer pictureId, Integer isCancel, Date creationTime) {
        this.userId = userId;
        this.pictureId = pictureId;
        this.isCancel = isCancel;
        this.creationTime = creationTime;
    }

    public Praise() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}