package edu.gq.bbpic.vo;

import edu.gq.bbpic.pojo.Category;

import java.util.List;

public class TagVo {
    private Integer tagId;

    private Category category;

    public TagVo(){

    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
