package cn.luozc.sso.repository;


import cn.luozc.sso.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by FantasticPan on 2018/6/4.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
