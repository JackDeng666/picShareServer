package edu.gq.bbpic.service.impl;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.CategoryMapper;
import edu.gq.bbpic.pojo.Category;
import edu.gq.bbpic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ServerResponse getAllCategory() {
        List cList = categoryMapper.selectAll();
        return new ServerResponse(Const.ResCode.SUCCEES, "获取分类列表成功", cList);
    }

    @Override
    public ServerResponse addCategory(Category category) {
        try{
            category.setSignUrl("");
            categoryMapper.insert(category);
            return new ServerResponse(Const.ResCode.SUCCEES, "添加分类成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse updateCategory(Category category) {
        try{
            categoryMapper.updateByPrimaryKeySelective(category);
            return new ServerResponse(Const.ResCode.SUCCEES, "修改分类成功");
        } catch (Exception e) {
            return new ServerResponse(Const.ResCode.ERROR, e.toString());
        }
    }

    @Override
    public ServerResponse delCategory(Category category) {
        return null;
    }
}
