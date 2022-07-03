package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.faceol.faceol_tieba.pojo.po.forum;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.service.PostService;
import top.faceol.faceol_tieba.service.forumService;
import top.faceol.faceol_tieba.service.userService;
import top.faceol.faceol_tieba.util.jwtUtil;

import java.util.*;

@RestController
public class hello {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("==========hello");
        return "hello";
    }
    @Autowired
    public userService userService;
    @Autowired
    public forumService forumService;
    @GetMapping("/text")
    public void text(){
        System.out.println("--------------");
        /*Page<forum> forumPage = new Page<>(1,2);
        IPage<forum> page = forumService.page(forumPage, new LambdaQueryWrapper<forum>().orderByDesc(forum::getScore));
        List<forum> records = page.getRecords();
        for (forum i:records
             ) {
            System.out.println("i+++++"+i.toString());
        }*/
    }
}
