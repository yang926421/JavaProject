package cn.gsxt.service.impl;

import cn.gsxt.dao.impl.provinceDaoImpl;
import cn.gsxt.dao.provinceDao;
import cn.gsxt.domain.Province;
import cn.gsxt.jedis.utils.JedisUtils;
import cn.gsxt.service.provinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class provinceServiceImpl implements provinceService {
    provinceDao dao =  new provinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //先从redis数据库中查询
        //获取redis客户端连接
        System.out.println("通过redis");
        Jedis jedis = JedisUtils.getJedis();
        String province_json = jedis.get("province");
        System.out.println(province_json);
        if (province_json == null || province_json.length() == 0){
            //redis中没有数据缓存没数据
            System.out.println("redis中没数据，查询数据库");
            List<Province> ps = dao.findAll();
            //将查询出来的数据序列化成json存放redis中
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将json数据存到redis中
            jedis.set("province", province_json);
            //归还连接
            jedis.close();

        }
        else{
            System.out.println("缓存中有数据,查询缓村");
        }
        return province_json;
    }
}
