package edu.gq.bbpic.service.impl;

import com.alibaba.fastjson.JSON;
import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.dao.CategoryMapper;
import edu.gq.bbpic.dao.PicListMapper;
import edu.gq.bbpic.dao.PictureMapper;
import edu.gq.bbpic.service.PicService;
import edu.gq.bbpic.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("picService")
public class PicServiceImpl implements PicService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private PicListMapper picListMapper;
    @Autowired
    private PictureMapper pictureMapper;

    @Value("${fileUploadPath}")
    private String fileUploadPath;
    @Value("${fileBasicUrl}")
    private String fileBasicUrl;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @Override
    public ServerResponse getCategory() {
        List cList = categoryMapper.selectAll();
        return new ServerResponse(Const.ResCode.SUCCEES, "获取分类列表成功", cList);
    }

    @Override
    public ServerResponse addPic(MultipartFile file) {
        String today = sdf.format(new Date());

        String oPath = fileUploadPath + today + "original";
        String tPath = fileUploadPath + today + "thumbnail";
        String[] array1 = oPath.split("/");
        String[] array2 = tPath.split("/");
        oPath = "";
        tPath = "";
        for (int i = 0; i < array1.length; i++) {
            oPath += array1[i] + File.separator;
            tPath += array2[i] + File.separator;
        }
        // 原图文件夹
        File folderOp = new File(oPath);
        // 缩略图文件夹
        File folderTp = new File(tPath);
        if (!folderOp.isDirectory()) {
            folderOp.mkdirs();
        }
        if (!folderTp.isDirectory()) {
            folderTp.mkdirs();
        }

        List list = new LinkedList();
//        for (MultipartFile file : files) {
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        String originalName = newName + oldName.substring(oldName.lastIndexOf("."));
        String thumbnailName = newName + ".jpg";
        try {
            // 存储原图
            File originalFile = new File(folderOp, originalName);
            file.transferTo(originalFile);
            // 存储缩略图
            ImageUtil.generateThumbnail(originalFile, tPath + thumbnailName);
            list.add(fileBasicUrl + today + "original/" + originalName);
            list.add(fileBasicUrl + today + "thumbnail/" + thumbnailName);
        } catch (IOException e) {
            e.printStackTrace();
            return new ServerResponse(Const.ResCode.FAIL, "上传失败");
        }
//        }
        return new ServerResponse(Const.ResCode.SUCCEES, "上传成功", list);
    }
}
