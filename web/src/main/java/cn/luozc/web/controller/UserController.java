package cn.luozc.web.controller;



import cn.luozc.domain.JsonData;
import cn.luozc.domain.User;
import cn.luozc.service.UserService;
import cn.luozc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/6/18.
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public R<Integer> addUser(User user){
        user= new User();
        user.setPhone("133443545");
        user.setPassword("123443");
        user.setUserName("用户名");
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/test")
    public JsonData test(){
        int i = 1/0;
        return JsonData.success();
    }

}
