package top.faceol.faceol_tieba.config;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import top.faceol.faceol_tieba.pojo.po.forum;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.service.PostService;
import top.faceol.faceol_tieba.service.forumService;
import top.faceol.faceol_tieba.util.cacheUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Autowired
    private RedisTemplate redisTemplate;
    @Qualifier("postServiceImpl")
    @Autowired
    private PostService postsService;
    @Autowired
    private forumService forumService;
    //3.添加定时任务
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：60秒
    @Scheduled(fixedRate=1000*20)
    private void configureTasks() {
        /*System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        //更新贴吧排行榜并将热门表存入redis
        Set<String> range = redisTemplate.opsForZSet().range(cacheUtil.hotForum, 0, -1);
        redisTemplate.opsForZSet().removeRange(cacheUtil.hotForum,0,-1);
        redisTemplate.opsForValue().set(cacheUtil.selectHotForum,range);
        //更新帖子排行榜并将热门表存入redis
        range = redisTemplate.opsForZSet().range(cacheUtil.hotPosts, 0, -1);
        redisTemplate.opsForZSet().removeRange(cacheUtil.hotPosts,0,-1);
        redisTemplate.opsForValue().set(cacheUtil.selectHotPosts,range);

        Set<String> followId = redisTemplate.opsForHash().keys(cacheUtil.forumFollowCache);
        Set<String> postId = redisTemplate.opsForHash().keys(cacheUtil.forumPostCache);
        Set<String> commentId = redisTemplate.opsForHash().keys(cacheUtil.postCommentCache);
        Set<String> likeId = redisTemplate.opsForHash().keys(cacheUtil.postLikeCache);

        //更新关注数缓存到数据库
        List<Integer> followList = redisTemplate.opsForHash().multiGet(cacheUtil.forumFollowCache, followId);
        LambdaUpdateWrapper<forum> followerLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        int i=0;
        for (String id:followId
             ) {
            Integer scope = followList.get(i);
            followerLambdaUpdateWrapper.eq(forum::getId,id).setSql("followers=followers+"+scope);
            i++;
            forumService.update();
        }
        //更新发帖数缓存到数据库
        List<Integer> postList = redisTemplate.opsForHash().multiGet(cacheUtil.forumPostCache, postId);
        LambdaUpdateWrapper<forum> postLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        i=0;
        for (String id:postId
        ) {
            Integer scope = postList.get(i);
            postLambdaUpdateWrapper.eq(forum::getId,id).setSql("posts=posts+"+scope);
            i++;
            forumService.update();
        }
        //更新评论数缓存到数据库
        List<Integer> commentList = redisTemplate.opsForHash().multiGet(cacheUtil.postCommentCache, postId);
        LambdaUpdateWrapper<post> commentLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        i=0;
        for (String id:commentId
        ) {
            Integer scope = commentList.get(i);
            commentLambdaUpdateWrapper.eq(post::getId,id).setSql("comment_count=comment_count+"+scope);
            i++;
            postsService.update();
        }
        //更新点赞数到数据库
        List<Integer> likeList = redisTemplate.opsForHash().multiGet(cacheUtil.postLikeCache, postId);
        LambdaUpdateWrapper<post> likeLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        i=0;
        for (String id:likeId
        ) {
            Integer scope = likeList.get(i);
            likeLambdaUpdateWrapper.eq(post::getId,id).setSql("like_count=like_count+"+scope);
            i++;
            postsService.update();
        }*/
    }
}