package top.faceol.faceol_tieba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.faceol.faceol_tieba.pojo.po.forum;

import java.util.List;

@Mapper
public interface forumMapper extends BaseMapper<forum> {
    @Select("select forum_id from fa_forum_user where user_id=#{id}")
    List getIdByUser(int id);
    void follower(int userid,int forumId);
}
