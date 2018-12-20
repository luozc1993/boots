package cn.luozc.service.sys;

import cn.luozc.domain.sys.SysUser;
import cn.luozc.repository.sys.SysUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;


/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 17:10 2018/12/20/020
 */
@Service
public class SysUserService {

    @Resource
    private SysUserRepository sysUserRepository;


    /**
     * save、update、delete 方法需要绑定事务。使用 @Transactional进行事务绑定
     * @param sysUser
     * @return
     */
    @Transactional
    public SysUser save(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }

    /**
     * 根据id删除对象
     * @param id
     */
    @Transactional
    public void delete(int id){
        sysUserRepository.deleteById(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    public Iterable<SysUser> getAll(){
        return sysUserRepository.findAll();
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public SysUser getById(int id){
        return sysUserRepository.findById(id).get();
    }

    /**
     * 修改用户信息，持久化对象修改会更新到数据库
     * @param sysUser
     */
    @Transactional
    public void update(SysUser sysUser){
        //直接调用持久化对象的set方法修改对象数据
        sysUser.setUsername("修改名字");
    }

}
