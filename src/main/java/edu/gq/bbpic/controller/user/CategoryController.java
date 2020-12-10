package edu.gq.bbpic.controller.user;

import edu.gq.bbpic.common.Const;
import edu.gq.bbpic.common.ServerResponse;
import edu.gq.bbpic.pojo.Category;
import edu.gq.bbpic.service.CategoryService;
import edu.gq.bbpic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    public ServerResponse getCategory() {
        return categoryService.getAllCategory();
    }

    // 管理员接口
    @PostMapping("addCategory")
    public ServerResponse addCategory(@RequestHeader Map<String, String> headers, @RequestBody Category category) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return categoryService.addCategory();
    }

    @PostMapping("updateCategory")
    public ServerResponse updateCategory(@RequestHeader Map<String, String> headers, @RequestBody Category category) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return categoryService.updateCategory();
    }
}
