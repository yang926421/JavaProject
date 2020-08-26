package cn.gsxt.ssm1.service.impl;

import cn.gsxt.ssm1.dao.ItemMapper;
import cn.gsxt.ssm1.pojo.Item;
import cn.gsxt.ssm1.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    public Item findById(int id) {
        return itemMapper.findById(id);
    }
}