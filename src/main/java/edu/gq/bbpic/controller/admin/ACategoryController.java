package edu.gq.bbpic.controller.admin;

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
public class ACategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PostMapping("addCategory")
    public ServerResponse addCategory(@RequestHeader Map<String, String> headers, @RequestBody Category category) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return categoryService.addCategory(category);
    }

    @PostMapping("updateCategory")
    public ServerResponse updateCategory(@RequestHeader Map<String, String> headers, @RequestBody Category category) {
        String token = headers.get(Const.AUTH);
        ServerResponse response = userService.checkAdminToken(token);
        if (response.getStatus() != Const.ResCode.SUCCEES) {
            return response;
        }
        return categoryService.updateCategory(category);
    }
}
