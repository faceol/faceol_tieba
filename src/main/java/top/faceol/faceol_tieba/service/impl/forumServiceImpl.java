package top.faceol.faceol_tieba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.dao.forumMapper;
import top.faceol.faceol_tieba.pojo.po.forum;
import top.faceol.faceol_tieba.service.forumService;

import java.util.List;

@Service
public class forumServiceImpl extends ServiceImpl<forumMapper, forum> implements forumService {
    @Override
    public List<Integer> getForumIdByUser(int id) {
        return baseMapper.getIdByUser(id);
    }
    @Override
    public void follower(int userid, int forumId) {
        baseMapper.follower(userid,forumId);
    }
}
