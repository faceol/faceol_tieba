package top.faceol.faceol_tieba.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class myMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("create",LocalDateTime.now(),metaObject);
        this.setInsertFieldValByName("modified",LocalDateTime.now(),metaObject);
        /*this.strictInsertFill(metaObject,"create", LocalDateTime.class,LocalDateTime.now());
        this.strictUpdateFill(metaObject,"modified",LocalDateTime.class,LocalDateTime.now());*/
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("modified",LocalDateTime.now(),metaObject);
        /*this.strictUpdateFill(metaObject,"modified",LocalDateTime.class,LocalDateTime.now());*/
    }
}
