package cn.luozc.wechat.service;

import cn.luozc.wechat.domian.Bill;
import cn.luozc.wechat.domian.WechatUserInfo;
import cn.luozc.wechat.repository.BillRepository;
import cn.luozc.wechat.repository.WechatUserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

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
    private BillRepository billRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
     * @param bill
     * @return
     */
    public Bill addExpenditure(Bill bill){
        return billRepository.save(bill);
    }

    /**
     * 获取指定时间范围支出数据
     * @param openid    用户微信小程序id
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @return  String
     */
    public String getBillSum(String openid,long startTime,long endTime){
        return  billRepository.getExpenditureSum(openid,startTime,endTime);
    }

    /**
     * 获取指定时间范围支出数据
     * @param openid    用户微信小程序id
     * @param startTime 起始时间
     * @param endTime   结束时间
     * @return  String
     */
    public String getIncomeSum(String openid,long startTime,long endTime){
        return  billRepository.getIncomeSum(openid,startTime,endTime);
    }
}
