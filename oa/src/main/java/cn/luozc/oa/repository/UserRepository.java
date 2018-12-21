package cn.luozc.oa.repository;

import cn.luozc.oa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户持久层
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 13:52 2018/12/21/021
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    @Query("select u.userId from User u where u.userId not in(select u.userId from User u inner join u.roles r where r.id = ?1)")
    List<String> getRolesUsers(Long id);

    @Query("select u.userId from User u inner join u.roles r where r.id = ?1")
    List<String> findRoleUsers(Long id);

    /**
     * 根据登录名查询用户
     * @param name
     * @return
     */
    User findByName(String name);

}
