package top.faceol.faceol_tieba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.dao.commentMapper;
import top.faceol.faceol_tieba.pojo.po.comment;
import top.faceol.faceol_tieba.service.commentService;
@Service
public class commentServiceImpl extends ServiceImpl<commentMapper, comment> implements commentService {

}
