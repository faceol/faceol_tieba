package top.faceol.faceol_tieba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.dao.postBodyMapper;
import top.faceol.faceol_tieba.pojo.po.postBody;
import top.faceol.faceol_tieba.service.postBodyService;
@Service
public class postBodyServiceImpl extends ServiceImpl<postBodyMapper, postBody> implements postBodyService {
    @Override
    public int saveBody(postBody postBody){
        return baseMapper.insert(postBody);
    }
}
