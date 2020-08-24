package cn.gsxt.controller;

import cn.gsxt.domain.Account;
import cn.gsxt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //保存账户信息
    @RequestMapping(value = "/save", produces = "text/html;character=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }



    //查询账户信息
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Account> accountList = accountService.findAll();
        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
