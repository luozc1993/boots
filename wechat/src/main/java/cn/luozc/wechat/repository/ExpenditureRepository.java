package cn.luozc.wechat.repository;

import cn.luozc.wechat.domian.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
}
