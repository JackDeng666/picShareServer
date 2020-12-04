package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.PicList;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PicService {
    ServerResponse addPicList(PicList picList);
    ServerResponse uploadSinglePic(MultipartFile file, Map map);
    ServerResponse uploadPicToList(MultipartFile file, Map map);

    ServerResponse getPicList(int currentPage, int pageSize, String type, int enable);

    ServerResponse getPicSetList(int currentPage, int pageSize, String type, int enable);
}
