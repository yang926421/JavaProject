package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    FavoriteDao favoriteDao = new FavoriteDaoImpl();
    RouteDao routeDao = new RouteDaoImpl();

    @Override
    public Boolean register(User user) {
        User u = dao.findUserByUsername(user.getUsername());
        if (u != null) {
            //用户名存在
            return false;
        }

        //设置用户的唯一激活码  java提供的方法 根据硬件及各种信息生成一个全球唯一的一个字符串
        user.setCode(UuidUtil.getUuid());
        System.out.println(456789);
        //设置激活状态
        user.setStatus("N");
        dao.save(user);
        //激活邮件发送，设置邮件内容
        String content = "<a href='http://localhost/travel/activeUserServlet?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");
        return true;
    }

    /**
     * 激活用户
     */
    @Override
    public boolean active(String code) {
        //根据激活码查询
        User user = dao.findUserByCode(code);
        if (user != null) {
            //调用dao的修改方法修改status属性
            dao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        //调用dao去查询
        System.out.println("跳转service登陆");
        User u = dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println("登陆返回user" + u.getName());
        return u;
    }

    @Override
    public List<Route> findFavoriteByUid(int uid) {
        //获取到当前user对象所有的收藏
        List<Map<String, Object>> list = dao.findFavoriteByUid(uid);
        System.out.println(list);
        //根据当前的uid和rid去favrite_dao查询具体的favorite对象,将所有对象返回到列表中
        ArrayList<Route> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get("rid"));
            //根据rid去查询线路
            list1.add(routeDao.findOne((int) list.get(i).get("rid")));
        }
        return list1;
    }
}
