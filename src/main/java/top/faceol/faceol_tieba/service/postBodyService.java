package top.faceol.faceol_tieba.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.faceol.faceol_tieba.pojo.po.postBody;

public interface postBodyService extends IService<postBody> {
    public int saveBody(postBody postBody);
}
