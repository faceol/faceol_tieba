package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import top.faceol.faceol_tieba.enums.weightEnum;
import top.faceol.faceol_tieba.pojo.dto.Result;
import top.faceol.faceol_tieba.enums.resultCode;
import top.faceol.faceol_tieba.pojo.dto.myPage;
import top.faceol.faceol_tieba.pojo.dto.postParam;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.pojo.po.postBody;
import top.faceol.faceol_tieba.pojo.dto.publish;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.service.*;
import top.faceol.faceol_tieba.util.cacheUtil;
import top.faceol.faceol_tieba.util.userThreadLocal;


@RestController
@RequestMapping("post")
public class postController {
    @Autowired
    private PostService postService;
    @Autowired
    private commentService commentService;
    @Autowired
    private forumService forumService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private userService userService;
    @Autowired
    private postBodyService postBodyService;
    @Autowired
    private cacheUtil cache;
    @PostMapping("/publish")
    public Result publish(@RequestBody publish publish){
        post post = new post();
        BeanUtils.copyProperties(publish,post);
        postBody postBody = new postBody(0,publish.getMain());
        int bodyId = postBodyService.saveBody(postBody);

        post.setBodyId(bodyId);
        post.setUserId(userThreadLocal.get().getId());
        post.setForumId(publish.getForumId());

        postService.save(post);
        boolean save = postService.save(post);
        if (!save){
            return Result.fail(resultCode.INSERT_ERROR,null);
        }
        return Result.success(resultCode.INSERT,null);
    }
    @GetMapping("/getOne/{id}")
    public Result getOne(@PathVariable("id") int id){
        postParam postParam = new postParam();
        LambdaQueryWrapper<post> postLambdaQueryWrapper = new LambdaQueryWrapper<>();
        postLambdaQueryWrapper.eq(post::getId,id);
        post post = postService.getOne(postLambdaQueryWrapper);
        BeanUtils.copyProperties(post,postParam);

        postBody bodyById = postService.getBodyById(id);
        postParam.setBody(bodyById.getBody());

        user one = userService.getOne(new LambdaQueryWrapper<user>().eq(user::getId, post.getUserId()));
        postParam.setNickName(one.getNickname());
        postParam.setUserAva(one.getAvatar());

        return Result.success(resultCode.SELECT,postParam);
    }
   /* @PostMapping("/list")
    public Result postList(@RequestBody myPage myPage){
        Page<post> page = new Page<>(myPage.getIndex(), myPage.getSize());
        LambdaQueryWrapper<post> postsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        *//*List<Integer> idByForum = postService.getIdByForum(1);
        postsLambdaQueryWrapper.in(post::getId,idByForum);*//*
        postsLambdaQueryWrapper.eq(post::getForumId,1);
        IPage<post> re = postService.page(page,postsLambdaQueryWrapper);
        if (re!=null){
            return Result.success(resultCode.SELECT,re);
        }else {
            return Result.fail(resultCode.SELECT_ERROR,null);
        }
    }*/
    @PostMapping("/hot")
    public Result hot(@RequestBody myPage myPage){
        /*List<post> posts = cache.hotPort();*/
        Page<post> postPage = new Page<>(myPage.getIndex(), myPage.getSize());
        IPage<post> page = postService.page(postPage,
                new LambdaQueryWrapper<post>().eq(post::getForumId, myPage.getId()).orderByDesc(post::getScore));
        return Result.success(resultCode.SELECT,page);
    }
    @PostMapping("/like/{id}")
    public Result like(@PathVariable("id") int id){
        user user = userThreadLocal.get();
        cache.postsUpdateCache(weightEnum.LIKE,user.getId(),id);
        return Result.success(resultCode.INSERT,null);
    }
    //按修改时间对帖子进行排行
    @PostMapping("/latest")
    public Result latest(@RequestBody myPage myPage){
        Page<post> page = new Page<>(myPage.getIndex(), myPage.getSize());
        IPage<post> postIPage = postService.page(page,
                new LambdaQueryWrapper<post>().eq(post::getForumId, myPage.getId()).orderByDesc(post::getModified));
        if (postIPage.getRecords()==null)
            return Result.fail(resultCode.SELECT_ERROR,null);
        else
            return Result.success(resultCode.SELECT,postIPage);
    }
}
