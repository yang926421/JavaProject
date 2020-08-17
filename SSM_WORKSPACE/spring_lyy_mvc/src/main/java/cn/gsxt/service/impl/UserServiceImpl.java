package cn.gsxt.service.impl;

import cn.gsxt.dao.RoleDao;
import cn.gsxt.dao.UserDao;
import cn.gsxt.domain.Role;
import cn.gsxt.domain.User;
import cn.gsxt.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        //获取到这些user但是还要去根据user去查询他们的属性list
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            //获得user的id
            Long id = user.getId();
            //将id作为参数 查询当前userId对应的Role集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            System.out.println(roles);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步向user表中存储数据
        Long userId = userDao.save(user);
        //
        //向sys_user_role表中存储数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    @Override
    public void del(Long userId) {
        //删除sys_user_role关系表
        userDao.delUserRoleRel(userId);
        //删除user表
        userDao.del(userId);
    }
}
