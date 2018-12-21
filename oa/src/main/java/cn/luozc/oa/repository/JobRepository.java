package cn.luozc.oa.repository;

import cn.luozc.oa.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * 植物持久层
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:47 2018/12/21/021
 */
public interface JobRepository extends JpaRepository<Job, String> {

    /**
     * 获取所有职务信息
     * @return
     * @throws Exception
     */
    @Query("select new Map(j.code as code ,j.name as name) from Job j")
    public List<Map<String, Object>> findJobs() throws Exception ;

}