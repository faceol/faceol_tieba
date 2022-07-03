package top.faceol.faceol_tieba.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class comment{
    private int id;
    private int score;
    @TableField("post_id")
    private int postId;
    @TableField("user_id")
    private int userId;
    private String main;
    @TableField("like_count")
    private int likeCount;
    @TableField("`type`")
    private int type;
    @TableField("`from`")
    private int from;
    @TableField(fill = FieldFill.INSERT,value = "`create`")
    private LocalDateTime create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified;

    public comment() {
    }

    public comment(int id, int score, int postId, int userId, String main, int likeCount, int type, int from, LocalDateTime create, LocalDateTime modified) {
        this.id = id;
        this.score = score;
        this.postId = postId;
        this.userId = userId;
        this.main = main;
        this.likeCount = likeCount;
        this.type = type;
        this.from = from;
        this.create = create;
        this.modified = modified;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public LocalDateTime getCreate() {
        return create;
    }

    public void setCreate(LocalDateTime create) {
        this.create = create;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
