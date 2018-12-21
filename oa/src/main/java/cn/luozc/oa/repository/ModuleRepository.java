package cn.luozc.oa.repository;

import cn.luozc.oa.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 模块持久层
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:48 2018/12/21/021
 */
public interface ModuleRepository extends JpaRepository<Module, String>, JpaSpecificationExecutor<Module> {


    @Modifying
    @Query("delete Module m where m.code like ?1")
    public void setCode(String code) ;

    /**
     * 查询所有模块信息
     * @param parentCode
     * @param sonCodeLen
     * @return
     */
    @Query("select m from Module m where m.code like :parentCode and length(m.code) = :sonCodeLen")
    public List<Module> findModules(@Param("parentCode")String parentCode, @Param("sonCodeLen")int sonCodeLen);

    @Query("select Max(m.code) from Module m where m.code like :parentCode and  length(m.code) = :sonCodeLen ")
    public String findUniqueEntity(@Param("parentCode")String parentCode, @Param("sonCodeLen")int sonCodeLen);


}