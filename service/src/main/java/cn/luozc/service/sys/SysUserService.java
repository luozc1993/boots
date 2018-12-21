package cn.luozc.service.sys;

import cn.luozc.domain.sys.SysUser;
import cn.luozc.repository.sys.SysUserRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


/**
 * @Author: luozhicong
 * @Description:
 * @Date: Create in 17:10 2018/12/20/020
 */
@Service
public class SysUserService {

    @Resource
    private SysUserRepository sysUserRepository;
    @Resource
    private JdbcTemplate jdbcTemplate;

    public SysUser findById(int id){
        return sysUserRepository.findById(id);
    }

    public SysUser save(SysUser sysUser){
        return sysUserRepository.save(sysUser);
    }

    public SysUser jdbcTemplateFindById(int id){
        String sql = "select * from sys_user where id=?";
        RowMapper<SysUser> rowMapper = new BeanPropertyRowMapper<>(SysUser.class);
        SysUser sysUser = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        return sysUser;
    }

}
