package top.faceol.faceol_tieba.util;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import top.faceol.faceol_tieba.enums.weightEnum;
import top.faceol.faceol_tieba.pojo.dto.forumParam;
import top.faceol.faceol_tieba.pojo.po.forum;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.service.PostService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
@Component
@Lazy
public class cacheUtil {
    //热门贴吧
    public static final String hotForum="hotForum";
    //热门帖子
    public static final String hotPosts="hotPosts";
    //热门帖子缓存表
    public static final String selectHotPosts="selectHotPosts";
    @Autowired
    private RedisTemplate redisTemplate;
    public int getForumCountCache(weightEnum weight,int id){
        Object o = redisTemplate.opsForHash().get("count" + weight.getCache(), id);
        if (o==null)
            return 0;
        return (int)o;
    }
    public int getForumUserCache(weightEnum weight,int usrId,int forumId){
        String re;
        re= (String) redisTemplate.opsForHash().get(weight.getCache(), usrId+"::"+forumId);
        if (re==null)
            return 0;
        System.out.println("++++++++++++"+re);
        String[] split = re.split("::");
        return Integer.parseInt(split[0]);
    }
    public void getForumCache(List<forumParam> forumParams,int userId){
        for (int i = 0; i < forumParams.size(); i++) {
            forumParam forumParam = forumParams.get(i);
            System.out.println(forumParam.toString());
            //将缓存关注数与数据库关注数相加
            int followerCache = getForumCountCache(weightEnum.FOLLOWER, forumParam.getId());
            int postCache = getForumCountCache(weightEnum.POST, forumParam.getId());
            forumParams.get(i).setFollowers(forumParam.getFollowers()+followerCache);
            forumParams.get(i).setPosts(forumParam.getPosts()+postCache);
            //从缓存中取出用户操作记录
            int isFollower = getForumUserCache(weightEnum.FOLLOWER, userId, forumParam.getId());
            forumParams.get(i).setIsFollower(isFollower%2);
        }
    }
    //更新贴吧的缓存
    public int forumUpdateCache(weightEnum weight,int from,int to){
        int random = (int) (Math.random()*60000)+25*1000;
        Long score=-1l;
        score = redisTemplate.opsForHash().increment(weight.getCache(), "count"+to,weight.getWeight());
        //奇数为进行了操作，偶数为取消了操作
        redisTemplate.opsForHash().increment(weight.getCache(),from+"::"+to,1);
        return Integer.parseInt(String.valueOf(score));
    }


    //更新贴吧排行，返回分数
    public int forumUpdateRank(int id, weightEnum weight){
        Double score = redisTemplate.opsForZSet().incrementScore(hotForum, id, weight.getWeight());
        return Integer.parseInt(String.valueOf(score));
    }
    //获取热门贴吧
    public List<forum> hotForum(){
        Set hot = (Set) redisTemplate.opsForValue().get(cacheUtil.selectHotPosts);
        List list = redisTemplate.opsForValue().multiGet(hot);
        return list;
    }
    //更新帖子的缓存
    public int postsUpdateCache(int id,weightEnum weight){
        int random = (int) (Math.random()*60000)+25*1000;
        Long score=-1l;
        score = redisTemplate.opsForHash().increment(weight.getCache(), id, weight.getWeight());
        return Integer.parseInt(String.valueOf(score));
    }
    //更新帖子的缓存
    public int postsUpdateCache(weightEnum weight,int from,int to){
        int random = (int) (Math.random()*60000)+25*1000;
        Long score=-1l;
        score = redisTemplate.opsForHash().increment(weight.getCache(), "count"+to, weight.getWeight());
        redisTemplate.opsForHash().put(weight.getCache(),to,from+"::"+to);
        return Integer.parseInt(String.valueOf(score));
    }



    //更新帖子排行，返回分数
    public int postsUpdateRank(String id, weightEnum weight){
        Double score = redisTemplate.opsForZSet().incrementScore(hotPosts, id, weight.getWeight());
        return Integer.parseInt(String.valueOf(score));
    }


    //获取热门帖子
    public List<post> hotPort(){
        String s = (String) redisTemplate.opsForValue().get(cacheUtil.selectHotPosts);
        Set set = JSON.parseObject(s, Set.class);
        List list = redisTemplate.opsForValue().multiGet(set);
        return list;
    }
}
