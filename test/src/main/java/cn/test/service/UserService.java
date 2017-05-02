package cn.test.service;

import cn.test.pojo.TUser;

import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 */
public interface UserService {
    public TUser findUserById(Integer id) throws Exception;
    public int  addUserById(TUser user) throws  Exception;
    public int  deleteUserById(Integer id) throws  Exception;
    public int updateUserById(Integer id ,TUser tUser) throws  Exception;
}
