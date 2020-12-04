package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {
    ServerResponse getAllCategory();
    ServerResponse addCategory();
    ServerResponse delCategory();
    ServerResponse updateCategory();
}
