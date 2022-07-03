package top.faceol.faceol_tieba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.faceol.faceol_tieba.pojo.po.user;

@Mapper
public interface userMapper extends BaseMapper<user> {
    
}
