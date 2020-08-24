package cn.gsxt.ssm.service.impl;

import cn.gsxt.ssm.dao.ItemMapper;
import cn.gsxt.ssm.pojo.Item;
import cn.gsxt.ssm.service.ItemService;
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