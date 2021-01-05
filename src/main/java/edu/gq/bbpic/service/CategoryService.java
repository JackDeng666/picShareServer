package edu.gq.bbpic.service;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.Category;
import org.springframework.web.multipart.MultipartFile;

public interface CategoryService {
    ServerResponse getAllCategory();
    ServerResponse addCategory(Category category);
    ServerResponse delCategory(Category category);
    ServerResponse updateCategory(Category category);
}
