package edu.gq.bbpic.pojo;

public class Tag {
    private Integer categoryId;

    private Integer objectId;

    private Integer objectType;

    public Tag(Integer categoryId, Integer objectId, Integer objectType) {
        this.categoryId = categoryId;
        this.objectId = objectId;
        this.objectType = objectType;
    }

    public Tag() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public void setObjectType(Integer objectType) {
        this.objectType = objectType;
    }
}