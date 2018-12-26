package cn.luozc.wechat.repository;

import cn.luozc.wechat.domian.WechatUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 14:45 2018/12/26/026
 */
public interface WechatUserInfoRepository extends JpaRepository<WechatUserInfo, Long> {

    /**
     * 通过微信id获取微信信息
     * @param openid    微信id
     * @return  微信信息
     */
    WechatUserInfo findWechatUserInfoByOpenid(String openid);
}
