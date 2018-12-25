package cn.luozc.wechat.controller;

import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.api.impl.WxMaUserServiceImpl;
import cn.luozc.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wechat")
public class UserCentroller {

    @RequestMapping("/findOpenidByCode")
    @ResponseBody
    public JsonData findOpenidByCode(String code){
        return JsonData.success();
    }
}
