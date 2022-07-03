package top.faceol.faceol_tieba.pojo.dto;

import java.time.LocalDateTime;

public class postParam {
    private int id;
    private String head;
    private int userId;
    private String nickName;
    private String userAva;
    private String body;
    private int viewCount;
    private int likeCount;
    private LocalDateTime create;
    private LocalDateTime modified;

    public postParam() {
    }

    public postParam(int id, String head, int userId, String userName, String userAva, String body, int viewCount, int likeCount, LocalDateTime create, LocalDateTime modified) {
        this.id = id;
        this.head = head;
        this.userId = userId;
        this.nickName = userName;
        this.userAva = userAva;
        this.body = body;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.create = create;
        this.modified = modified;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserAva() {
        return userAva;
    }

    public void setUserAva(String userAva) {
        this.userAva = userAva;
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



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
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
