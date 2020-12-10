package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.PicList;
import edu.gq.bbpic.pojo.Picture;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PicService {
    ServerResponse addPicList(Map map);

    ServerResponse uploadSinglePic(MultipartFile file, Map map);

    ServerResponse uploadPicToList(MultipartFile file, Map map);

    ServerResponse getPicList(int currentPage, int pageSize, String type, int enable, int categoryId);

    ServerResponse getPicSetList(int currentPage, int pageSize, String type, int enable, int categoryId);

    ServerResponse updatePicture(Picture picture);

    ServerResponse updatePicList(PicList picList);
}
