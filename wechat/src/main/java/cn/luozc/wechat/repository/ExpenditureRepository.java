package cn.luozc.wechat.repository;

import cn.luozc.wechat.domian.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    /**
     * 获取指定时间范围支出数据
     * @param openid    //用户微信id
     * @param startTime //起始时间戳
     * @param endTime   //结束时间戳
     * @return  //金额
     */
    @Query(" select sum(a.money) from Expenditure a where a.type=1 and a.openid = :openid and a.time>:startTime and a.time< :endTime")
    String getExpenditureSum(@Param("openid") String openid,@Param("startTime")long startTime,@Param("endTime")long endTime);

    /**
     * 获取指定时间范围支出数据
     * @param openid    //用户微信id
     * @param startTime //起始时间戳
     * @param endTime   //结束时间戳
     * @return  //金额
     */
    @Query(" select sum(a.money) from Expenditure a where a.type=2 and a.openid = :openid and a.time>:startTime and a.time< :endTime")
    String getIncomeSum(@Param("openid") String openid,@Param("startTime")long startTime,@Param("endTime")long endTime);
}
