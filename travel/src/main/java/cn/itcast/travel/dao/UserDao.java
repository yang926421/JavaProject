package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public User findUserByUsername(String username);

    public void save(User user);


    User findUserByCode(String code);

    void updateStatus(User user);

    User findUserByUsernameAndPassword(String username, String password);

    List<Map<String, Object>> findFavoriteByUid(int uid);
}
