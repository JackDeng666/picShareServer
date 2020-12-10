package edu.gq.bbpic.service;

import com.alibaba.fastjson.JSON;
import edu.gq.bbpic.dao.CategoryMapper;
import edu.gq.bbpic.dao.PictureMapper;
import edu.gq.bbpic.pojo.Category;
import edu.gq.bbpic.pojo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduledTaskService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private PictureMapper pictureMapper;
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate= 2 * 60 * 60000)
    private void configureTasks() {
        List<Category> categories = categoryMapper.selectAll();
        for (Category cate: categories) {
            List<Picture> pictures = pictureMapper.selectHotByCategory(0,1, 0, cate.getCategoryId());
            cate.setSignUrl(pictures.get(0).getThumbnailUrl());
            categoryMapper.updateByPrimaryKeySelective(cate);
        }
    }
}
