package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PicService {
    ServerResponse getCategory();
    ServerResponse addPic(MultipartFile file);
}
