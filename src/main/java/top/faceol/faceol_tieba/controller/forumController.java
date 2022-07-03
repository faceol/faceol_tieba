package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.faceol.faceol_tieba.enums.weightEnum;
import top.faceol.faceol_tieba.pojo.dto.Result;
import top.faceol.faceol_tieba.enums.resultCode;
import top.faceol.faceol_tieba.pojo.dto.forumParam;
import top.faceol.faceol_tieba.pojo.po.forum;
import top.faceol.faceol_tieba.pojo.dto.myPage;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.service.forumService;
import top.faceol.faceol_tieba.util.cacheUtil;
import top.faceol.faceol_tieba.util.userThreadLocal;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/forum")
public class forumController {
    @Autowired
    private forumService forumService;
    @Autowired
    private cacheUtil cache;
    public List<forumParam> forumParamsCopy(List forums){
        ArrayList<forumParam> forumParams = new ArrayList<>();
        for (int i = 0; i < forums.size(); i++) {
            forumParam forumParam = new forumParam();
            BeanUtils.copyProperties(forums.get(i),forumParam);
            forumParams.add(forumParam);
        }
        return forumParams;
    }
    @Cacheable
    @GetMapping("/msg/{id}")
    public Result getForumById(@PathVariable("id") int id){
        forum one = forumService.getOne(new LambdaQueryWrapper<forum>().eq(forum::getId, id));
        forumParam forumParam = new forumParam();
        BeanUtils.copyProperties(one,forumParam);
        ArrayList<top.faceol.faceol_tieba.pojo.dto.forumParam> forumParams = new ArrayList<>();
        cache.getForumCache(forumParams,userThreadLocal.get().getId());
        return Result.success(resultCode.SELECT,forumParams.get(0));
    }

    @PostMapping("/hot")
    public Result getHotForum(@RequestBody myPage myPage){
        Page<forum> page = new Page<>(myPage.getIndex(), myPage.getSize());
        IPage forumIPage = forumService.page(page, new LambdaQueryWrapper<forum>().orderByDesc(forum::getScore));
        List<forum> records = forumIPage.getRecords();
        List<forumParam> forumParams = forumParamsCopy(records);
        cache.getForumCache(forumParams,userThreadLocal.get().getId());
        forumIPage.setRecords(forumParams);
        return Result.success(resultCode.SELECT,forumIPage);
    }
    @PostMapping("/userForum")
    public Result getForumByUser(@RequestBody myPage myPage){
        Page<forum> page = new Page<>(myPage.getIndex(), myPage.getSize());
        user user = userThreadLocal.get();
        int id = user.getId();
        System.out.println("id+++++++++"+id);
        List<Integer> forumIds = forumService.getForumIdByUser(id);
        IPage forums = forumService.page(page,
                new LambdaQueryWrapper<forum>().in(forum::getId,forumIds).orderByDesc(forum::getModified));
        List<forum> records = forums.getRecords();
        List<forumParam> forumParams = forumParamsCopy(records);
        cache.getForumCache(forumParams,userThreadLocal.get().getId());
        forums.setRecords(forumParams);
        return Result.success(resultCode.SELECT,forums);
    }
    @GetMapping("/follower/{id}")
    public Result follower(@PathVariable("id") int id){
        user user = userThreadLocal.get();
        int userId = user.getId();
        System.out.println("--------"+userId+"---------"+id);
        cache.forumUpdateCache(weightEnum.FOLLOWER, userId, id);
        return Result.success(resultCode.INSERT,null);
    }
}
