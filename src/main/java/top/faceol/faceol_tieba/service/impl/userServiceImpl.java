package top.faceol.faceol_tieba.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.dao.userMapper;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.service.userService;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, user> implements userService{
}
