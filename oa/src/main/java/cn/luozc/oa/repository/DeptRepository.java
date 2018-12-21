package cn.luozc.oa.repository;

import cn.luozc.oa.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * 部门持久层
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:45 2018/12/21/021
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {

    /**
     * 获取所有部门信息
     * @return
     */
    @Query("select new Map(p.id as code , p.name as name) from Dept p")
    public List<Map<String, Object>> findDepts();

}
