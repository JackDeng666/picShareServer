package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public ServerResponse getCategory() {
        return categoryService.getAllCategory();
    }
}
