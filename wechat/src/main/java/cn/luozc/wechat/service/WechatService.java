package cn.luozc.wechat.service;

import cn.luozc.wechat.domian.Expenditure;
import cn.luozc.wechat.domian.WechatUserInfo;
import cn.luozc.wechat.repository.ExpenditureRepository;
import cn.luozc.wechat.repository.WechatUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 14:47 2018/12/26/026
 */
@Service
public class WechatService {

    @Autowired
    private WechatUserInfoRepository wechatUserInfoRepository;

    @Autowired
    private ExpenditureRepository expenditureRepository;

    /**
     * 根据openid获取用户微信信息
     * @param openid 微信id
     * @return  返回WechatUserInfo对象
     */
    public WechatUserInfo getWechatUserInfo(String openid){
        return wechatUserInfoRepository.findWechatUserInfoByOpenid(openid);
    }

    /**
     * 添加用户信息
     * @param wechatUserInfo    需要添加的对象
     * @return  返回添加的对象
     */
    public WechatUserInfo addWechatUserInfo(WechatUserInfo wechatUserInfo){
        return wechatUserInfoRepository.save(wechatUserInfo);
    }

    /**
     * 添加账单记录
     * @param expenditure
     * @return
     */
    public Expenditure addExpenditure(Expenditure expenditure){
        return expenditureRepository.save(expenditure);
    }

}
