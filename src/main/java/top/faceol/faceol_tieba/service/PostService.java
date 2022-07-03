package top.faceol.faceol_tieba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.faceol.faceol_tieba.pojo.po.post;
import top.faceol.faceol_tieba.pojo.po.postBody;

import java.util.List;

@Service
public interface PostService extends IService<post> {
    List<Integer> getIdByForum(int id);
    postBody getBodyById(int id);
}
