package top.faceol.faceol_tieba.pojo.vo;

import java.time.LocalDateTime;

public class postDetailedVo {
    private int id;
    private int userId;
    private String userNickName;
    private String userAvatar;
    private String head;
    private String main;
    private int commentCount;
    private int likeCount;
    private LocalDateTime modified;

    public postDetailedVo(int id, int userId, String userNickName, String userAvatar, String head, String main, int commentCount, int likeCount, LocalDateTime modified) {
        this.id = id;
        this.userId = userId;
        this.userNickName = userNickName;
        this.userAvatar = userAvatar;
        this.head = head;
        this.main = main;
        this.commentCount = commentCount;
        this.likeCount = likeCount;
        this.modified = modified;
    }

    public postDetailedVo() {
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

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
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
