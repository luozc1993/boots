package com.wf.ew.system.controller;

import com.wf.ew.common.BaseController;
import com.wf.ew.common.JsonResult;
import com.wf.ew.system.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018-07-13 上午 11:21.
 */
@Controller()
@RequestMapping("/home")
public class HomeController extends BaseController {

    /**
     * 控制台
     */
    @RequestMapping("/console")
    public String console() {
        return "home/console.html";
    }

    /**
     * 消息弹窗
     */
    @RequestMapping("/message")
    public String message() {
        return "tpl/message.html";
    }

    /**
     * 修改密码弹窗
     */
    @RequestMapping("/password")
    public String password() {
        return "tpl/password.html";
    }

    /**
     * 主题设置弹窗
     */
    @RequestMapping("/theme")
    public String theme() {
        return "tpl/theme.html";
    }

    /**
     * 主题设置弹窗
     */
    @RequestMapping("/note")
    public String note() {
        return "tpl/note.html";
    }

    /**
     * 设置主题
     */
    @RequestMapping("/setTheme")
    public String setTheme(String themeName, HttpServletRequest request) {
        if (null == themeName) {
            request.getSession().removeAttribute("theme");
        } else {
            request.getSession().setAttribute("theme", themeName);
        }
        return "redirect:/";
    }

    /**
     * 主题设置弹窗
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        model.addAttribute("loginUser", getLoginUser());
        return "tpl/user-info.html";
    }

    @ResponseBody
    @RequestMapping("/updateUserMassage")
    public JsonResult updateUserMassage(){
        User user = getLoginUser();
        System.err.println(user);
        return JsonResult.ok();
    }
}
