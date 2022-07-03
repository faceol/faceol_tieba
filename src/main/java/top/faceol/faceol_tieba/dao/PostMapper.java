package top.faceol.faceol_tieba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.pojo.po.postBody;

import java.util.List;

@Mapper
public interface PostMapper extends BaseMapper<post> {
    List getPostByForum(int id,int index,int size);
    @Select("select post_id from fa_post_forum where forum_id=#{id}")
    List<Integer> getIdByForum(int id);
    @Select("select * from fa_postBody where id=(select body_id from fa_post where id=#{id})")
    postBody getBodyById(int id);
}
