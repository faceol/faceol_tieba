package top.faceol.faceol_tieba.pojo.vo;

import java.time.LocalDateTime;

public class postBrieflyVo {
    private int id;
    private int userId;
    private String userNickName;
    private String head;
    private int commentCount;
    private int likeCount;
    private LocalDateTime modified;

    public postBrieflyVo(int id, int userId, String userNickName, String head, int commentCount, int likeCount, LocalDateTime modified) {
        this.id = id;
        this.userId = userId;
        this.userNickName = userNickName;
        this.head = head;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.modified = modified;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public postBrieflyVo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
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

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
