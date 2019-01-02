package cn.luozc.wechat.repository;

import cn.luozc.wechat.domian.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BillRepository extends JpaRepository<Bill, Long> {

    /**
     * 获取指定时间范围支出数据
     * @param openid    //用户微信id
     * @param startTime //起始时间戳
     * @param endTime   //结束时间戳
     * @return  //金额
     */
    @Query(" select sum(a.money) from Bill a where a.type=1 and a.openid = :openid and a.time>:startTime and a.time< :endTime")
    String getExpenditureSum(@Param("openid") String openid,@Param("startTime")long startTime,@Param("endTime")long endTime);

    /**
     * 获取指定时间范围支出数据
     * @param openid    //用户微信id
     * @param startTime //起始时间戳
     * @param endTime   //结束时间戳
     * @return  //金额
     */
    @Query(" select sum(a.money) from Bill a where a.type=0 and a.openid = :openid and a.time>:startTime and a.time< :endTime")
    String getIncomeSum(@Param("openid") String openid,@Param("startTime")long startTime,@Param("endTime")long endTime);
}
