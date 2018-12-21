package cn.luozc.web.controller.sys;

import cn.luozc.domain.JsonData;
import cn.luozc.domain.sys.SysUser;
import cn.luozc.service.sys.SysUserService;
import cn.luozc.utils.MD5Util;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 9:28 2018/12/21/021
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping(value = "/get/{id}" ,method = RequestMethod.GET)
    public JsonData get(@PathVariable int id){
        return JsonData.success(sysUserService.findById(id));
    }


    @RequestMapping(value = "/save")
    public JsonData save(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser.setPassword(MD5Util.getMD5Str("123456"));
        sysUser.setAge("100");
        sysUser.setSex("男");
        sysUserService.save(sysUser);


        return JsonData.success();
    }

    @RequestMapping(value = "/get2/{id}" ,method = RequestMethod.GET)
    public JsonData get2(@PathVariable int id){
        System.out.println("热部署222");

        return JsonData.success(sysUserService.findById(id));
    }
}
