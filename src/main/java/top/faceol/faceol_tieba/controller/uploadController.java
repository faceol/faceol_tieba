package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.faceol.faceol_tieba.pojo.dto.Result;
import top.faceol.faceol_tieba.enums.resultCode;
import top.faceol.faceol_tieba.pojo.po.user;
import top.faceol.faceol_tieba.util.userThreadLocal;

import java.io.*;

@RestController
@RequestMapping("/upload")
public class uploadController {

    @Autowired
    private top.faceol.faceol_tieba.service.userService userService;
    @PostMapping("/avatar")
    public Result upload(@RequestParam MultipartFile file) throws IOException {
        if (!file.isEmpty()) {

            String path = "E:\\java\\img\\";
            File temp = new File(path);
            if (!temp.exists()) {
                try {
                    temp.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //图片命名
            String fileName = file.getOriginalFilename();
            File avaFile = new File(path + fileName);
            file.transferTo(avaFile);
            user user = userThreadLocal.get();
            LambdaUpdateWrapper<top.faceol.faceol_tieba.pojo.po.user> wrapper = new LambdaUpdateWrapper<>();
            wrapper.eq(top.faceol.faceol_tieba.pojo.po.user::getId,user.getId());
            wrapper.set(top.faceol.faceol_tieba.pojo.po.user::getAvatar,path+fileName);
            boolean update = userService.update(user,wrapper);
            if (!update){
                return Result.fail(resultCode.INSERT_ERROR,"上传头像失败");
            }
        }
        return Result.success(resultCode.INSERT,null);
    }
}
