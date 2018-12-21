package cn.luozc.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 15:22 2018/12/21/021
 */
@Controller
public class RequestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
