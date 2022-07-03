package top.faceol.faceol_tieba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.pojo.po.forum;

import java.util.List;

@Service
public interface forumService extends IService<forum> {
    List<Integer> getForumIdByUser(int id);
    void follower(int userid, int forumId);
}
