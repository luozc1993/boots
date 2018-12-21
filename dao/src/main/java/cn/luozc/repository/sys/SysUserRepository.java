package cn.luozc.repository.sys;

import cn.luozc.domain.sys.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 8:53 2018/12/21/021
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {

    /**
     * 通过用户id查询用户
     * @param id  用户id
     * @return SysUser对象
     */
    SysUser findById(int id);


    /**
     * 通过用户名和性别查询用户
     * @param username
     * @param sex
     * @return
     */
    SysUser findSysUserByUsernameAndSex(String username,String sex);
}
