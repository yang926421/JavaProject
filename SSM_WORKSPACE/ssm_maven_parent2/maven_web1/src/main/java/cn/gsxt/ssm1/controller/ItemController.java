package cn.gsxt.ssm1.controller;

import cn.gsxt.ssm1.pojo.Item;
import cn.gsxt.ssm1.service.ItemService;
import cn.gsxt.ssm1.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/showItem/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "item";
    }
}