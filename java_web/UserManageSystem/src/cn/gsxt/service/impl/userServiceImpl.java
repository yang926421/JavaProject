package cn.gsxt.service.impl;
import cn.gsxt.dao.impl.userDaoImpl;
import cn.gsxt.dao.userDao;
import cn.gsxt.domain.PageBean;
import cn.gsxt.domain.User;
import cn.gsxt.service.userService;

import java.util.List;

public class userServiceImpl implements userService {
    private userDao dao = new userDaoImpl();
    @Override
    public List<User> findAll(){
        //调用dao来完成查询
        return dao.findAll();
    }

    @Override
    public void addOne(User user) {
        dao.addOne(user);
    }

    @Override
    public User login(User user) {
        System.out.println(123);
        System.out.println(user.getUsername());
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void delUserById(int parseInt) {
        dao.delUserById(parseInt);
    }

    @Override
    public User findUserById(int parseInt) {

        return dao.findUserById(parseInt);
    }

    public void updateUser(User user) {
        //修改根据提交的user属性修改
        dao.updateUser(user);
    }

    //删除选中的所有人
    @Override
    public void delSelectedUser(String[] ids) {
        //批量删除用户
        for (String id : ids) {
            //
            dao.delUserById(Integer.parseInt(id));
        }
    }

    @Override
    //页码分页查询总记录数和当页数据
    public PageBean<User> findUserByPages(String _currentPage, String _rows) {
        //
        int currentPage = Integer.parseInt(_currentPage);
        if(currentPage <=0) {
            currentPage = 1;
        }
        int rows = Integer.parseInt(_rows);
        System.out.println(rows);
        PageBean<User> pb = new PageBean<User>();
        pb.setRows(rows);
        //dao.
        int totalCount = dao.findUsersCount();
        System.out.println(totalCount);
        int totalPage = (totalCount % rows) == 0 ? (totalCount % rows) : (totalCount % rows) + 1;
        pb.setTotalCount(totalCount);
        //计算总页码数
        if(currentPage >= totalPage){
            currentPage = totalPage;
        }
        pb.setCurrentPage(currentPage);
        //查询当前页码list,计算开始记录
        int start =  (currentPage - 1)*rows;
        List<User> list =  dao.findByPage(start, rows);
        pb.setList(list);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
