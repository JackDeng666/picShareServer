package edu.gq.bbpic.pojo;

import java.util.Date;

public class Collect {
    private Integer userId;

    private Integer ojectId;

    private Integer objectType;

    private Integer isCancel;

    private Date creationTime;

    public Collect(Integer userId, Integer ojectId, Integer objectType, Integer isCancel, Date creationTime) {
        this.userId = userId;
        this.ojectId = ojectId;
        this.objectType = objectType;
        this.isCancel = isCancel;
        this.creationTime = creationTime;
    }

    public Collect() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOjectId() {
        return ojectId;
    }

    public void setOjectId(Integer ojectId) {
        this.ojectId = ojectId;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
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