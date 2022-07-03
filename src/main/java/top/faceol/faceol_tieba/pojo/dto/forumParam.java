package top.faceol.faceol_tieba.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;

public class forumParam {
    private int id;
    private int score;
    private String name;
    private String type;
    private int followers;
    private int posts;
    private int isFollower;
    private String synopsis;
    private String img;

    public forumParam(int id, int score, String name, String type, int followers, int posts, int isFollower, String synopsis, String img) {
        this.id = id;
        this.score = score;
        this.name = name;
        this.type = type;
        this.followers = followers;
        this.posts = posts;
        this.isFollower = isFollower;
        this.synopsis = synopsis;
        this.img = img;
    }

    public forumParam() {
    }

    public int getIsFollower() {
        return isFollower;
    }

    public void setIsFollower(int isFollower) {
        this.isFollower = isFollower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "forumParam{" +
                "id=" + id +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", followers=" + followers +
                ", posts=" + posts +
                ", isFollower=" + isFollower +
                ", synopsis='" + synopsis + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
