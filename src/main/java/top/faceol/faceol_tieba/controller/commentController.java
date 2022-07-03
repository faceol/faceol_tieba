package top.faceol.faceol_tieba.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;
import top.faceol.faceol_tieba.enums.weightEnum;
import top.faceol.faceol_tieba.pojo.po.comment;
import top.faceol.faceol_tieba.pojo.dto.Result;
import top.faceol.faceol_tieba.enums.resultCode;
import top.faceol.faceol_tieba.pojo.dto.myPage;
import top.faceol.faceol_tieba.service.commentService;
import top.faceol.faceol_tieba.service.userService;

@RestController
@RequestMapping("/comment")
public class commentController {
    @Autowired
    private commentService commentService;
    @Autowired
    private userService userService;
    @PostMapping("/latest")
    public Result getCommentByPost(@RequestBody myPage myPage){
        Page<comment> page = new Page<>(myPage.getIndex(), myPage.getSize());
        IPage<comment> comments = commentService.page(page,
                new LambdaQueryWrapper<comment>().eq(comment::getPostId,myPage.getId()).orderByDesc(comment::getModified));
        return Result.success(resultCode.SELECT,comments);
    }
    @PostMapping("/hot")
    public Result hot(@RequestBody myPage myPage){
        Page<comment> page = new Page<>(myPage.getIndex(), myPage.getSize());
        LambdaQueryWrapper<comment> commentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentLambdaQueryWrapper.eq(comment::getPostId,myPage.getId()).orderByDesc(comment::getScore);
        IPage<comment> commentIPage = commentService.page(page, commentLambdaQueryWrapper);
        if (commentIPage.getRecords()==null){
            return Result.fail(resultCode.SELECT_ERROR,null);
        }else {
            return Result.success(resultCode.SELECT,null);
        }

    }
    @PostMapping("/like/{id}/{userId}")
    public Result like(@PathVariable("id") int id,@PathVariable("userId") int userId){
        boolean update = commentService.update(new LambdaUpdateWrapper<comment>().eq(comment::getId, id)
                .setSql("like_count=like_count+1").set(comment::getFrom, userId));
        /*cache.updateAll(String.valueOf(postId),String.valueOf(forumId), top.faceol.faceol_tieba.util.cacheUtil.likeWeight);*/
        if (update){
            return Result.success(resultCode.INSERT,null);
        }else{
            return Result.fail(resultCode.UPDATE_ERROR,null);
        }
    }

}
