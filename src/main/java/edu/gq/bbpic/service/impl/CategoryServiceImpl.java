package edu.gq.bbpic.service.impl;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.CategoryMapper;
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
    public ServerResponse addCategory() {
        return null;
    }

    @Override
    public ServerResponse delCategory() {
        return null;
    }

    @Override
    public ServerResponse updateCategory() {
        return null;
    }
}
