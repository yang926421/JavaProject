package cn.itcast.travel.service;

import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;

import java.util.List;

public interface UserService {
    Boolean register(User user);

    boolean active(String code);

    public User login(User user);

    List<Route> findFavoriteByUid(int uid);
}
