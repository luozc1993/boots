package cn.luozc.wechat.controller;

import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.luozc.utils.JsonData;
import cn.luozc.wechat.config.WxMaConfiguration;
import cn.luozc.wechat.domian.Expenditure;
import cn.luozc.wechat.domian.WechatUserInfo;
import cn.luozc.wechat.service.WechatService;
import me.chanjar.weixin.common.error.WxErrorException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 11:48 2018/12/26/026
 */
@RestController
@RequestMapping(value = "/wechat/{appid}")
public class WechatController {

    @Autowired
    private WechatService wechatService;

    /**
     * 使用code换取openid和sessionkey
     * 通过openid获取用户信息
     * @param appid 小程序appid
     * @param code code
     * @return  code换取的openid or sessionkey or 用户信息
     */
    @RequestMapping("/login")
    public JsonData login(@PathVariable String appid, String code, HttpSession session){
        try {
            //使用code换取openid or sessionkey
            WxMaJscode2SessionResult result = WxMaConfiguration.getMaService(appid).getUserService().getSessionInfo(code);
            String openid = result.getOpenid();

            //通过openid获取用户信息
            WechatUserInfo wechatUserInfo = wechatService.getWechatUserInfo(openid);

            JSONObject json = new JSONObject();
            json.accumulate("wechatUserInfo",wechatUserInfo==null?"":wechatUserInfo);
            json.accumulate("sessionKey",result.getSessionKey());
            json.accumulate("openid",result.getOpenid());
            json.accumulate("sessionId",session.getId());

            return JsonData.success(json);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return JsonData.fail();
    }

    /**
     * 添加用户微信信息
     * @param wechatUserInfo 微信信息
     * @return  微信信息
     */
    @RequestMapping("/addUserinfo")
    public JsonData addUserinfo(WechatUserInfo wechatUserInfo){
        WechatUserInfo userInfo = wechatService.getWechatUserInfo(wechatUserInfo.getOpenid());
        if(userInfo==null){
           return JsonData.success(wechatService.addWechatUserInfo(wechatUserInfo));
        }
        return JsonData.success(userInfo);
    }
    @RequestMapping("/addExpenditure")
    public JsonData addExpenditure(Expenditure expenditure){
        return JsonData.success( wechatService.addExpenditure(expenditure));
    }
}
