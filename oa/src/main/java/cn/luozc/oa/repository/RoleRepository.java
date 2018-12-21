package cn.luozc.oa.repository;

import cn.luozc.oa.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 角色持久层
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:51 2018/12/21/021
 */
public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

}
