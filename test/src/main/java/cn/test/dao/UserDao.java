package cn.test.dao;

import cn.test.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */
@Repository
public interface UserDao {
    public User getUser(Integer id);
    public int insertUser(Integer id);
    public int deletUser(Integer id);
    public int updateUser(User user);
    public List<User> findUsers(String username, RowBounds rowBounds);
}
