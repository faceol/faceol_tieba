package top.faceol.faceol_tieba.pojo.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.time.LocalDateTime;

public class post {
    private int id;
    private int score;
    private String head;
    @TableField("forum_id")
    private int forumId;
    @TableField("user_id")
    private int userId;
    @TableField("body_id")
    private int bodyId;
    @TableField("`comment_count`")
    private int commentCount;
    @TableField("view_count")
    private int viewCount;
    @TableField("like_count")
    private int likeCount;
    @TableField(fill = FieldFill.INSERT,value = "`create`")
    private LocalDateTime create;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modified;

    public post() {
    }

    public post(int id, int score, String head, int forumId, int userId, int bodyId, int commentCount, int viewCount, int likeCount, LocalDateTime create, LocalDateTime modified) {
        this.id = id;
        this.score = score;
        this.head = head;
        this.forumId = forumId;
        this.userId = userId;
        this.bodyId = bodyId;
        this.commentCount = commentCount;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.create = create;
        this.modified = modified;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBodyId() {
        return bodyId;
    }

    public void setBodyId(int bodyId) {
        this.bodyId = bodyId;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
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
