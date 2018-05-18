package com.mycat.controller;

import com.mycat.com.mycat.utils.SessionUtil;
import com.mycat.mapper.ItemMapper;
import com.mycat.pojo.Item;

import org.apache.ibatis.plugin.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @Autowired
    ItemMapper itemMapper;

    @GetMapping("/{id}")
    @ResponseBody
    public Object test(@PathVariable("id") int id){
    	System.out.println(id);
        return itemMapper.getOne(id);
    }

    //简化，直接通过这里设置session
    @GetMapping("/set/{sess}")
    @ResponseBody
    public Object setSession(@PathVariable("sess") String sess){
        HttpSession httpSession=SessionUtil.getSession();
        httpSession.setAttribute("corp",sess);
        return "ok";
    }

    
    @GetMapping("/count")
    @ResponseBody
    public Object getCount(){
        //要测试的方法

        return itemMapper.count();
    }
    	
    @PostMapping("/add")
    @ResponseBody
    public Object add(Item item){
    	itemMapper.insert(item);
    	return 1;
    }


    
}
