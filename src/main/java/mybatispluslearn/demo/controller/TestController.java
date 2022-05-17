package mybatispluslearn.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mybatispluslearn.demo.pojo.User;
import mybatispluslearn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    UserService userService;

    @RequestMapping("/a")
    public User getUser(){
        return userService.getOne(new QueryWrapper<User>().eq("id", 9));
    }

}
