package cn.test.service.impl;

import cn.test.mapper.TUserMapper;
import cn.test.pojo.TUser;
import cn.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/5/1.
 */
@Service
public class UserServiceImpl implements UserService {
    //此处需要使用注解方式注入mapper
    @Autowired
    private TUserMapper tUserMapper;

    public TUser findUserById(Integer id) throws Exception {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        return tUser;
    }

    public int addUserById(TUser user) throws Exception {
        int id = tUserMapper.insert(user);
//                返回新增的id
        return id;
    }

    public int deleteUserById(Integer id) throws Exception {
        int temp=0;
        if (id != null ) {
           temp = tUserMapper.deleteByPrimaryKey(id);
        }
        return temp;
    }

    public int updateUserById(Integer id, TUser tUser) throws Exception {
        int temp=0;
        if (id != null) {
            temp = tUserMapper.updateByPrimaryKey(tUser);
        }
        return temp;
    }
}
