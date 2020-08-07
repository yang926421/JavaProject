package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryImpl();
    @Override
    public List<Category> findAll() {
        //使用redis缓存查询
        Jedis jedis = JedisUtil.getJedis();
        System.out.println(jedis);
        //使用sortedSet来进行排序查询
//        有序集合类型 sortedset：不允许重复元素，且元素有顺序
//        Set<String> categorys = jedis.zrange("category", 0, -1);
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        List<Category> list = null;
        //判断查询的集合是否为空//空说明缓存没有，需要去数据库查询
        //非空，则将redis查询到的数据返回
        if(categorys == null || categorys.size()==0){
            //从数据库查询
            System.out.println("从数据库查询");
            list = dao.findAll();
            //查询之后将数据存储到redis中System.out.println("将数据存进redis中");
            for (int i = 0; i < list.size(); i++) {
                //根据cid的大小来存储
                jedis.zadd("category", list.get(i).getCid(), list.get(i).getCname());
            }
        }
        else{
            System.out.println("从resis查询"+"redis");
            //redis存储的是set集合的数据，但是我们需要的是list
            list = new ArrayList<Category>();
            for (Tuple tuple : categorys) {
                //页面上的参数为？uid = xx && name =xx,获取到服务器返回的参数
                //将存储在redis的数据取出来
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                list.add(category);
            }
        }
        return list;
    }
}
