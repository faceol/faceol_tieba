package top.faceol.faceol_tieba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.dao.PostMapper;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.pojo.po.postBody;
import top.faceol.faceol_tieba.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, post> implements PostService {
    @Override
    public List<Integer> getIdByForum(int id) {
        return baseMapper.getIdByForum(id);
    }

    @Override
    public postBody getBodyById(int id) {
        postBody bodyById = baseMapper.getBodyById(id);
        return bodyById;
    }
}
