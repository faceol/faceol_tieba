package top.faceol.faceol_tieba.pojo.dto;

public class likeParam {
    private int forumId;
    private int postId;

    public likeParam() {
    }

    public likeParam(int forumId, int postId) {
        this.forumId = forumId;
        this.postId = postId;
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
