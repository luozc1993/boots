package cn.luozc.service;


import cn.luozc.domain.User;
import cn.luozc.utils.R;
import com.github.pagehelper.PageInfo;


/**
 * Created by Administrator on 2018/6/18.
 */
public interface UserService {

    R<Integer> addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}

