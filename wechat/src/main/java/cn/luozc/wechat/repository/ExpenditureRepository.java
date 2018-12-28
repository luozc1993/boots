package cn.luozc.wechat.repository;

import cn.luozc.wechat.domian.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {

    @Query(" select sum(a.money) from Expenditure a where a.openid = :openid and a.time>:startTime and a.time< :endTime")
    String thisDaySum(@Param("openid") String openid,@Param("startTime")long startTime,@Param("endTime")long endTime);
}
